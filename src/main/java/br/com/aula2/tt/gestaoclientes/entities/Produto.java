package br.com.aula2.tt.gestaoclientes.entities;

public class Produto {
    private Long id;
    private String descricao;
    private String cor;
    private Integer quantidade;
    private Double preco;

    public Produto(Long id, String descricao, String cor, Integer quantidade, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
