package com.example.resort_unipar.controller;

import com.example.resort_unipar.model.Cliente;
import com.example.resort_unipar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.buscarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            clienteAtualizado.setId((id));
            clienteService.atualizarCliente(clienteAtualizado);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/form")
    public String cadastrarCliente(@RequestParam String nome, @RequestParam String cpf,
                                   @RequestParam String telefone, @RequestParam String rg,
                                   @RequestParam int idade, Model model) {
        Cliente cliente = new Cliente(null, nome, cpf, telefone, rg, idade);
        clienteService.cadastrarCliente(cliente);
        model.addAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return "cliente";
    }
}
