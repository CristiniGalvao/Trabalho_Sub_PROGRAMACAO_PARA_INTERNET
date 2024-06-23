package com.example.resort_unipar.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MenuController {
    @GetMapping("/")
    public String menu() {
        return "menu";
    }

    @GetMapping("/clientes/form")
    public String clienteForm() {
        return "cliente";
    }

    @GetMapping("/quartos/form")
    public String quartoForm() {
        return "quarto";
    }

    @GetMapping("/reservas/form")
    public String reservaForm() {
        return "reserva";
    }
}
