package com.example.resort_unipar.repository;

import com.example.resort_unipar.model.Quarto;

import java.util.ArrayList;
import java.util.List;

public class QuartoRepositoryImpl implements QuartoRepository{
    private List<Quarto> quartos = new ArrayList<>();
    @Override
    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    @Override
    public void atualizarQuarto(Quarto quarto) {
        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getId() == quarto.getId()) {
                quartos.set(i, quarto);
                return;
            }
        }
    }

    @Override
    public Quarto buscarPorId(int id) {
        for (Quarto quarto : quartos) {
            if (quarto.getId() == id) {
                return quarto;
            }
        }
        return null;
    }

    @Override
    public List<Quarto> buscarTodos() {
        return quartos;
    }

    @Override
    public List<Quarto> buscarTodosDisponiveis() {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                disponiveis.add(quarto);
            }
        }
        return disponiveis;
    }

    @Override
    public List<Quarto> buscarPorQtdOcupantes(int qtd) {
        List<Quarto> adequados = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.getQtdMaxOcupantes() >= qtd) {
                adequados.add(quarto);
            }
        }
        return adequados;
    }

    @Override
    public List<Quarto> buscarTodosComVistaMarEDisponiveis() {
        List<Quarto> comVistaMarEDisponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.isVistaMar() && quarto.isDisponivel()) {
                comVistaMarEDisponiveis.add(quarto);
            }
        }
        return comVistaMarEDisponiveis;
    }
}
