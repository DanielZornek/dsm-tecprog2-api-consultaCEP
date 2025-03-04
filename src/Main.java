import br.edu.fatecpg.tecprog.consultaCEP.model.Endereco;
import br.edu.fatecpg.tecprog.consultaCEP.service.ConsumoAPI;
import com.google.gson.Gson;

import java.io.*;

import java.time.ZonedDateTime;
import java.time.ZoneId;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.print("\nSistema de busca local via CEP\nOpções" +
                    "\n1- Buscar CEP" +
                    "\n2- Ver todos os CEPs consultados" +
                    "\n3- Sair\nEscolha: ");

            String escolha = entrada.nextLine();

            switch (escolha) {
                case "1":
                    buscarCEP();
                break;
                case "2":
                    System.out.println("Todos CEPs buscados:\n");
                    lerArquivo();
                break;
                case "3":
                    System.out.println("Programa finalizado!");
                    loop = false;
                break;
                default:
                    System.out.println("Opção inválida!");
                break;
            }
        }
    }

    public static void buscarCEP() throws IOException, InterruptedException {
        Gson g = new Gson();
        Scanner entrada = new Scanner(System.in);
        String cep;
        String resposta;

        System.out.print("CEP: ");
        try{
            cep = String.valueOf(entrada.nextLine());
            resposta = ConsumoAPI.obterDados("https://viacep.com.br/ws/"+cep+"/json/");
            Endereco endereco = g.fromJson(resposta, Endereco.class);
            registrarArquivo(endereco);
        } catch (RuntimeException e) {
            System.out.println("Tivemos um problema com entrada de dados, por favor tente novamente, padrão do CEP: 1234567x");
        }

    }

    public static void registrarArquivo(Endereco end) throws IOException {
        try{
            FileWriter arquivo = new FileWriter("registro.log", true);
            if (end.getCep() == null){
                System.out.println("CEP não encontrado!");
            }else{
                arquivo.write("CEP: "+end.getCep()
                        +"\nLogradouro: "+end.getLogradouro()
                        +"\nEstado: "+end.getEstado()
                        +"\nBairro: "+end.getBairro()
                        +"\nCidade: "+end.getCidade());
                DateTimeFormatter formatarAgora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));

                arquivo.write("\nBusca feita em: "+String.valueOf(formatarAgora.format(zdt))+"\n\n");
                arquivo.close();
                System.out.println("Registrado em registro.log");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerArquivo(){
        try{
            FileReader leitorArquivo = new FileReader("registro.log");
            BufferedReader brf = new BufferedReader(leitorArquivo);

            while(brf.ready()){
                System.out.println(brf.readLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}