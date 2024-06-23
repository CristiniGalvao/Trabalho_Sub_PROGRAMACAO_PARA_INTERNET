package com.example.resort_unipar.controller;

import com.example.resort_unipar.model.Quarto;
import com.example.resort_unipar.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    public ResponseEntity<Quarto> cadastrarQuarto(@RequestBody Quarto quarto) {
        Quarto quartoSalvo = quartoService.cadastrarQuarto(quarto);
        return ResponseEntity.status(201).body(quartoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quarto> atualizarQuarto(@PathVariable int id, @RequestBody Quarto quarto) {
        quarto.setId(id); // Garantindo que o ID seja o mesmo do path
        Quarto quartoAtualizado = quartoService.atualizarQuarto(quarto);
        return ResponseEntity.ok(quartoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarQuartoPorId(@PathVariable int id) {
        Quarto quarto = quartoService.buscarQuartoPorId(id);
        if (quarto != null) {
            return ResponseEntity.ok(quarto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Quarto>> buscarTodosQuartos() {
        List<Quarto> quartos = quartoService.buscarTodosQuartos();
        return ResponseEntity.ok(quartos);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Quarto>> buscarTodosDisponiveis() {
        List<Quarto> quartosDisponiveis = quartoService.buscarTodosDisponiveis();
        return ResponseEntity.ok(quartosDisponiveis);
    }

    @GetMapping("/qtdOcupantes/{qtdOcupantes}")
    public ResponseEntity<List<Quarto>> buscarPorQtdOcupantes(@PathVariable int qtdOcupantes) {
        List<Quarto> quartos = quartoService.buscarPorQtdOcupantes(qtdOcupantes);
        return ResponseEntity.ok(quartos);
    }

    @GetMapping("/vistaMar")
    public ResponseEntity<List<Quarto>> buscarTodosComVistaMar() {
        List<Quarto> quartos = quartoService.buscarTodosComVistaMarDisponiveis();
        return ResponseEntity.ok(quartos);
    }

    @PostMapping("/form")
    public String cadastrarQuarto(@RequestParam int qtdMaxOcupantes, @RequestParam boolean vistaMar, @RequestParam boolean disponivel,
                                  @RequestParam double valor, @RequestParam String descricao, Model model) {
        Quarto quarto = new Quarto(null, qtdMaxOcupantes, vistaMar, disponivel, valor, descricao);
        quartoService.cadastrarQuarto(quarto);
        model.addAttribute("mensagem", "Quarto cadastrado com sucesso!");
        return "quarto";
    }
}
