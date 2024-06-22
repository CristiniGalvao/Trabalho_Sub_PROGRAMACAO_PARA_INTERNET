package com.example.resort_unipar.repository;

import com.example.resort_unipar.model.Reserva;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReservaRepository {
    void adicionarReserva(Reserva reserva);
    void atualizarReserva(Reserva reserva);
    Reserva buscarReservaPorId(int id);
    List<Reserva> buscarTodasReservasPorHospede(String cpf);
    List<Reserva> buscarPorDataCheckin(LocalDateTime checkin);
}
