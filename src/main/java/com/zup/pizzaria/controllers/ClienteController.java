package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteRequestDTO;
import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> registrarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        try {
            // Converte ClienteRequestDTO para Cliente
            Cliente cliente = new Cliente();
            cliente.setNome(clienteRequestDTO.getNome());
            cliente.setEmail(clienteRequestDTO.getEmail());
            cliente.setTelefone(clienteRequestDTO.getTelefone());

            // Salva o cliente e retorna a resposta
            ClienteDTO clienteRegistrado = clienteService.salvarCliente(cliente);
            return ResponseEntity.status(201).body(clienteRegistrado); // HTTP 201 Created
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // HTTP 400 Bad Request
        }
    }
}
