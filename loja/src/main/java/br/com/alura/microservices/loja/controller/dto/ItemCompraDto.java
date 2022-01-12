package br.com.alura.microservices.loja.controller.dto;

public class ItemCompraDto {

    private Long id;
    private Integer quantidade;

    public ItemCompraDto(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
