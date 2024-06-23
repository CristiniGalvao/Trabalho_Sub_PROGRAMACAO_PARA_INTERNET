package com.example.resort_unipar.service;

import com.example.resort_unipar.model.Reserva;
import com.example.resort_unipar.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva cadastrarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva atualizarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva buscarReservaPorId(int id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> buscarTodasReservasPorHospede(String cpf) {
        return reservaRepository.findByClienteCpf(cpf);
    }

    public List<Reserva> buscarPorDataCheckin(LocalDateTime checkin) {
        return reservaRepository.findByCheckin(checkin);
    }
}
