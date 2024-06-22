package com.example.resort_unipar.service;

import com.example.resort_unipar.model.Cliente;
import com.example.resort_unipar.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        clienteRepository.adicionarCliente(cliente);
        return cliente;
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepository.atualizarCliente(cliente);
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.buscarPorId(id);
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.buscarTodos();
    }
}
