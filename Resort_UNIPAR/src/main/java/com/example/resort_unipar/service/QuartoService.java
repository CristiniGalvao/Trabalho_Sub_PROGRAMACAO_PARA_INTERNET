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
        quartoRepository.adicionarQuarto(quarto);
        return quarto;
    }

    public Quarto atualizarQuarto(Quarto quarto) {
        quartoRepository.atualizarQuarto(quarto);
        return quarto;
    }

    public Quarto buscarQuartoPorId(int id) {
        return quartoRepository.buscarPorId(id);
    }

    public List<Quarto> buscarTodosQuartos() {
        return quartoRepository.buscarTodos();
    }

    public List<Quarto> buscarTodosDisponiveis() {
        return quartoRepository.buscarTodosDisponiveis();
    }

    public List<Quarto> buscarPorQtdOcupantes(int qtdOcupantes) {
        return quartoRepository.buscarPorQtdOcupantes(qtdOcupantes);
    }

    public List<Quarto> buscarTodosComVistaMarDisponiveis() {
        return quartoRepository.buscarTodosComVistaMarEDisponiveis();
    }
}
