package br.edu.fatecpg.tecprog.consultaCEP.model;

import com.google.gson.annotations.SerializedName;

public class Endereco {
    private String cep;
    private String logradouro;
    private String estado;
    private String bairro;
    @SerializedName("localidade")
    private String cidade;

    public String getLogradouro() {
        return logradouro;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", estado='" + estado + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
