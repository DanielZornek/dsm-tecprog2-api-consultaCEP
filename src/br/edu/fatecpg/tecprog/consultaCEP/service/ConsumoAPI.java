package br.edu.fatecpg.tecprog.consultaCEP.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public static String obterDados(String endereco) throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> resposta = cliente.
                send(requisicao, HttpResponse.BodyHandlers.ofString());

        return resposta.body();
    }
}
