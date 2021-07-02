package br.com.aula2.tt.gestaoclientes.dto;

import java.util.List;

public class PedidoDTO {
    private List<ProdutoDTO> produtos;

    public PedidoDTO(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public PedidoDTO() {
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
