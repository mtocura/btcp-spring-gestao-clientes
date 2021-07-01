package br.com.aula2.tt.gestaoclientes.entities;

import java.util.List;

public class Pedido {
    private Long id;
    private List<Produto> produtos;
    private Double total;

    public Pedido(Long id, List<Produto> produtos, Double total) {
        this.id = id;
        this.produtos = produtos;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
