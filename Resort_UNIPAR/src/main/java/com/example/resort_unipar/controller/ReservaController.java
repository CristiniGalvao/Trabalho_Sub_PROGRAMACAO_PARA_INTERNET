package com.example.resort_unipar.controller;

import com.example.resort_unipar.model.Reserva;
import com.example.resort_unipar.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public Reserva cadastraReserva(@RequestBody Reserva reserva) {
        return reservaService.cadastrarReserva(reserva);
    }

    @PutMapping("/{id}")
    public Reserva atualizaReserva(@PathVariable int id, @RequestBody Reserva reserva) {
        reserva.setId(id); // Garantindo que o ID seja o mesmo do path
        return reservaService.atualizarReserva(reserva);
    }

    @GetMapping("/{id}")
    public Reserva buscarReservaPorId(@PathVariable int id) {
        return reservaService.buscarReservaPorId(id);
    }

    @GetMapping("/porHospede/{cpf}")
    public List<Reserva> buscarTodasReservasPorHospede(@PathVariable String cpf) {
        return reservaService.buscarTodasReservasPorHospede(cpf);
    }

    @GetMapping("/porDataCheckin")
    public List<Reserva> buscarPorDataCheckin(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkin) {
        return reservaService.buscarPorDataCheckin(checkin);
    }
}
