package com.example.resort_unipar.service;

import com.example.resort_unipar.model.Quarto;
import com.example.resort_unipar.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {
    private final QuartoRepository quartoRepository;

    @Autowired
    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public Quarto cadastrarQuarto(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public Quarto atualizarQuarto(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public Quarto buscarQuartoPorId(int id) {
        return quartoRepository.findById(id).orElse(null);
    }

    public List<Quarto> buscarTodosQuartos() {
        return quartoRepository.findAll();
    }

    public List<Quarto> buscarTodosDisponiveis() {
        return quartoRepository.findByDisponivelTrue();
    }

    public List<Quarto> buscarPorQtdOcupantes(int qtdOcupantes) {
        return quartoRepository.findByQtdMaxOcupantes(qtdOcupantes);
    }

    public List<Quarto> buscarTodosComVistaMarDisponiveis() {
        return quartoRepository.findByVistaMarTrueAndDisponivelTrue();
    }
}
