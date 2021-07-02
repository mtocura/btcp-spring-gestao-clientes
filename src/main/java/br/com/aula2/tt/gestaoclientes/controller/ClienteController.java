package br.com.aula2.tt.gestaoclientes.controller;

import br.com.aula2.tt.gestaoclientes.dao.ClienteDAO;
import br.com.aula2.tt.gestaoclientes.dto.ClienteDTO;
import br.com.aula2.tt.gestaoclientes.dto.ClienteResponseDTO;
import br.com.aula2.tt.gestaoclientes.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/aula2/tt")
public class ClienteController {

    private ClienteDAO clienteDAO = new ClienteDAO();

    @GetMapping("/clientes")
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok(clienteDAO.findAll());
    }

    @GetMapping("/clientes/{cpf}")
    public ResponseEntity<?> getPedidosClienteByCPF(@PathVariable String cpf) {
        ClienteResponseDTO cliente = clienteDAO.findClient(cpf);

        if(cliente != null) {
            return ResponseEntity.ok(cliente);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> createClient(@RequestBody ClienteDTO clienteDTO, UriComponentsBuilder uriBuilder) {
        Cliente cliente = clienteDAO.addCliente(clienteDTO);

        URI uri = uriBuilder.path("/aula2/tt/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
