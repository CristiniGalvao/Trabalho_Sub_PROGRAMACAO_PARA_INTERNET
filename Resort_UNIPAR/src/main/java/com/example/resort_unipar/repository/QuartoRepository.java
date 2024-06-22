package com.example.resort_unipar.repository;

import com.example.resort_unipar.model.Quarto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuartoRepository {
    void adicionarQuarto(Quarto quarto);
    void atualizarQuarto(Quarto quarto);
    Quarto buscarPorId(int id);
    List<Quarto> buscarTodos();
    List<Quarto> buscarTodosDisponiveis();
    List<Quarto> buscarPorQtdOcupantes(int qtd);
    List<Quarto> buscarTodosComVistaMarEDisponiveis();
}
