package com.example.resort_unipar.controller;

import com.example.resort_unipar.model.Quarto;
import com.example.resort_unipar.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
    private final QuartoService quartoService;

    @Autowired
    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping
    public Quarto cadastrarQuarto(@RequestBody Quarto quarto) {
        return quartoService.cadastrarQuarto(quarto);
    }

    @PutMapping("/{id}")
    public Quarto atualizarQuarto(@PathVariable int id, @RequestBody Quarto quarto) {
        quarto.setId(id); // Garantindo que o ID seja o mesmo do path
        return quartoService.atualizarQuarto(quarto);
    }

    @GetMapping("/{id}")
    public Quarto buscarQuartoPorId(@PathVariable int id) {
        return quartoService.buscarQuartoPorId(id);
    }

    @GetMapping
    public List<Quarto> buscarTodosQuartos() {
        return quartoService.buscarTodosQuartos();
    }

    @GetMapping("/disponiveis")
    public List<Quarto> buscarTodosDisponiveis() {
        return quartoService.buscarTodosDisponiveis();
    }

    @GetMapping("/qtdOcupantes/{qtdOcupantes}")
    public List<Quarto> buscarPorQtdOcupantes(@PathVariable int qtdOcupantes) {
        return quartoService.buscarPorQtdOcupantes(qtdOcupantes);
    }

    @GetMapping("/vistaMar")
    public List<Quarto> buscarTodosComVistaMar() {
        return quartoService.buscarTodosComVistaMarDisponiveis();
    }
}
