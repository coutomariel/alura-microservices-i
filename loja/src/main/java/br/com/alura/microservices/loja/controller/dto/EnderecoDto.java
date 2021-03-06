package br.com.alura.microservices.loja.controller.dto;

public class EnderecoDto {

    private String rua;
    private Integer numero;
    private String estado;

    public EnderecoDto(String rua, Integer numero, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
