package br.edu.fatecpg.tecprog.consultaCEP.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Endereco {
    private String cep;
    private String logradouro;
    private String estado;
    private String bairro;
    @SerializedName("localidade")
    private String cidade;

    public String getLogradouro() {
        if (Objects.equals(this.logradouro, "")) return "Indisponível";
        else return logradouro;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        if (Objects.equals(this.estado, "")) return "Indisponível";
        else return estado;
    }

    public String getCidade() {
        if (Objects.equals(this.cidade, "")) return "Indisponível";
        else return cidade;
    }

    public String getBairro() {
        if (Objects.equals(this.bairro, "")) return "Indisponível";
        else return bairro;
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
