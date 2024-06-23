package com.example.resort_unipar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int qtdMaxOcupantes;
    private boolean vistaMar;
    private boolean disponivel;
    private double valor;
    private String descricao;

    public Quarto(Integer id,int qtdMaxOcupantes, boolean vistaMar, boolean disponivel ,double valor, String descricao) {
        this.id = id;
        this.qtdMaxOcupantes = qtdMaxOcupantes;
        this.vistaMar = vistaMar;
        this.disponivel = disponivel;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Quarto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public int getQtdMaxOcupantes() {
        return qtdMaxOcupantes;
    }

    public void setQtdMaxOcupantes(int qtdMaxOcupantes) {
        this.qtdMaxOcupantes = qtdMaxOcupantes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isVistaMar() {
        return vistaMar;
    }

    public void setVistaMar(boolean vistaMar) {
        this.vistaMar = vistaMar;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return id == quarto.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
