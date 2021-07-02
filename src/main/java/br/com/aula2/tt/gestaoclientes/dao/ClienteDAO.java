package br.com.aula2.tt.gestaoclientes.dao;

import br.com.aula2.tt.gestaoclientes.dto.*;
import br.com.aula2.tt.gestaoclientes.entities.Cliente;
import br.com.aula2.tt.gestaoclientes.entities.Pedido;
import br.com.aula2.tt.gestaoclientes.entities.Produto;
import br.com.aula2.tt.gestaoclientes.utils.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO {
    private static List<Cliente> clientes = new ArrayList<>();

    public static Cliente clienteDtoToEntity(ClienteDTO clienteDTO) {
        return new Cliente(
                Id.generateIDCliente(),
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getEmail(),
                clienteDTO.getTelefone(),
                pedidoDtoToEntity(clienteDTO.getPedidos())
        );
    }

    public static ClienteResponseDTO entityToDTO(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                entityToPedidoResponseDTO(cliente.getPedidos())
        );
    }

    public static List<ClienteResponseDTO> entityToDTO(List<Cliente> cliente) {
        List<ClienteResponseDTO> clienteDTOS = new ArrayList<>();

        for (Cliente c: cliente) {
            clienteDTOS.add(entityToDTO(c));
        }

        return clienteDTOS;
    }

    public static Pedido pedidoDtoToEntity(PedidoDTO pedidoDTO) {
        return new Pedido(
                Id.generateIDPedido(),
                produtoDtoToEntity(pedidoDTO.getProdutos()),
                totalPedido(pedidoDTO.getProdutos())
        );
    }

    public static List<Pedido> pedidoDtoToEntity(List<PedidoDTO> pedidoDTOS) {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoDTO pedidoDTO : pedidoDTOS) {
            pedidos.add(pedidoDtoToEntity(pedidoDTO));
        }

        return pedidos;
    }

    public static PedidoResponseDTO entityToPedidoResponseDTO(Pedido pedido) {
        return new PedidoResponseDTO(
                entityToProdutoDTO(pedido.getProdutos()),
                pedido.getTotal()
        );
    }

    public static List<PedidoResponseDTO> entityToPedidoResponseDTO(List<Pedido> pedidos) {
        List<PedidoResponseDTO> pedidoResponseDTOS = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            pedidoResponseDTOS.add(entityToPedidoResponseDTO(pedido));
        }

        return pedidoResponseDTOS;
    }

    public static Produto produtoDtoToEntity(ProdutoDTO produtoDTO) {
        return new Produto(
                Id.generateIDProduto(),
                produtoDTO.getDescricao(),
                produtoDTO.getCor(),
                produtoDTO.getQuantidade(),
                produtoDTO.getPreco()
        );
    }

    public static List<Produto> produtoDtoToEntity(List<ProdutoDTO> produtoDTOS) {
        List<Produto> produtos = new ArrayList<>();

        for (ProdutoDTO produtoDTO : produtoDTOS) {
            produtos.add(produtoDtoToEntity(produtoDTO));
        }

        return produtos;
    }

    public static ProdutoDTO entityToProdutoDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getDescricao(),
                produto.getCor(),
                produto.getQuantidade(),
                produto.getPreco()
        );
    }

    public static List<ProdutoDTO> entityToProdutoDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();

        for (Produto produto : produtos) {
            produtoDTOS.add(entityToProdutoDTO(produto));
        }

        return produtoDTOS;
    }

    public Cliente addCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteDtoToEntity(clienteDTO);
        clientes.add(cliente);
        return cliente;
    }

    public List<ClienteResponseDTO> findAll() {
        return entityToDTO(clientes);
    }

    public ClienteResponseDTO findClient(String cpf) {
        Optional<Cliente> clienteOptional = clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findAny();

        if(clienteOptional.isPresent()) {
            return entityToDTO(clienteOptional.get());
        }

        return null;
    }

    private static double totalPedido(List<ProdutoDTO> produtoDTOS) {
        double total = 0;

        for (ProdutoDTO produtoDTO : produtoDTOS) {
            total += produtoDTO.getPreco() * produtoDTO.getQuantidade();
        }

        return total;
    }
}
