package com.example.resort_unipar.repository;

import com.example.resort_unipar.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByClienteCpf(String cpf);
    List<Reserva> findByCheckin(LocalDateTime checkin);
}
