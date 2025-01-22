package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        //converte lista de entity para dto
        return clientes.stream()
                .map(cliente -> new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone()))
                .collect(Collectors.toList());
    }

    public ClienteDTO salvarCliente(Cliente clienteRequestDTO) {
        // Converte DTO para entity Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setEmail(clienteRequestDTO.getEmail());
        cliente.setTelefone(clienteRequestDTO.getTelefone());

        // Salva entity no repo
        Cliente clienteSalvo = clienteRepository.save(cliente);

        // Converte entity salva de volta para DTO e retorna
        return new ClienteDTO(clienteSalvo.getId(), clienteSalvo.getNome(), clienteSalvo.getEmail(), clienteSalvo.getTelefone());
    }
}