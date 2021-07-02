package br.com.aula2.tt.gestaoclientes.dao;

import br.com.aula2.tt.gestaoclientes.dto.ClienteDTO;
import br.com.aula2.tt.gestaoclientes.entities.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO {
    private static List<Cliente> clientes = new ArrayList<>();

    public static Cliente clienteDtoToEntity(ClienteDTO clienteDTO) {
        return new Cliente(
                (long) clientes.size() + 1,
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getEmail(),
                clienteDTO.getTelefone(),
                clienteDTO.getPedidos()
        );
    }

    public static ClienteDTO entityToDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getPedidos()
        );
    }

    public static List<ClienteDTO> entityToDTO(List<Cliente> cliente) {
        List<ClienteDTO> clienteDTOS = new ArrayList<>();

        cliente.forEach(c -> clienteDTOS.add(entityToDTO(c)));

        return clienteDTOS;
    }

    public Cliente addCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteDtoToEntity(clienteDTO);
        clientes.add(cliente);
        return cliente;
    }

    public List<ClienteDTO> findAll() {
        return entityToDTO(clientes);
    }

    public ClienteDTO findClient(String cpf) {
        Optional<Cliente> clienteOptional = clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findAny();

        if(clienteOptional.isPresent()) {
            return entityToDTO(clienteOptional.get());
        }

        return null;
    }

    public ClienteDTO findClient(long id) {
        Optional<Cliente> clienteOptional = clientes.stream().filter(cliente -> cliente.getId() == id).findAny();

        if(clienteOptional.isPresent()) {
            return entityToDTO(clienteOptional.get());
        }

        return null;
    }
}
