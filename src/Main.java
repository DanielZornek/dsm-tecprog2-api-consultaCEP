import br.edu.fatecpg.tecprog.consultaCEP.model.Endereco;
import br.edu.fatecpg.tecprog.consultaCEP.service.ConsumoAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson g = new Gson();
        Scanner entrada = new Scanner(System.in);
        boolean loop = true;
        String escolha;

        while(loop){
            System.out.println("Sistema de busca local via CEP\nOpções" +
                    "\n1- Buscar CEP" +
                    "\n2- Ver todos os CEPs consultados" +
                    "\n3- Sair");

        }

        String resposta = ConsumoAPI.obterDados("https://viacep.com.br/ws/01001000/json/");
        Endereco endereco = g.fromJson(resposta, Endereco.class);

    }
}