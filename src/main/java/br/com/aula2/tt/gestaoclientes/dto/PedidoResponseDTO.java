package br.com.aula2.tt.gestaoclientes.dto;

import java.util.List;

public class PedidoResponseDTO {
    private List<ProdutoDTO> produtos;
    private Double total;

    public PedidoResponseDTO(List<ProdutoDTO> produtos, Double total) {
        this.produtos = produtos;
        this.total = total;
    }

    public PedidoResponseDTO() {
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
