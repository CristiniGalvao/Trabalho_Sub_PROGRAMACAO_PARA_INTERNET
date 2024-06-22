package com.example.resort_unipar.repository;

import com.example.resort_unipar.model.Cliente;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ClienteRepository {
    void adicionarCliente(Cliente cliente);
    void atualizarCliente(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> buscarTodos();
}
