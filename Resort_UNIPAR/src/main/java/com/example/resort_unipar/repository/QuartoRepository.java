package com.example.resort_unipar.repository;

import com.example.resort_unipar.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    List<Quarto> findByDisponivelTrue();
    List<Quarto> findByQtdMaxOcupantes(int qtd);
    List<Quarto> findByVistaMarTrueAndDisponivelTrue();
}
