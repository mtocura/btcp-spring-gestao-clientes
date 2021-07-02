package br.com.aula2.tt.gestaoclientes.dto;

import br.com.aula2.tt.gestaoclientes.entities.Pedido;

import java.util.List;

public class ClienteResponseDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<PedidoResponseDTO> pedidos;

    public ClienteResponseDTO(String nome, String cpf, String email, String telefone, List<PedidoResponseDTO> pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public ClienteResponseDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<PedidoResponseDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoResponseDTO> pedidos) {
        this.pedidos = pedidos;
    }
}
