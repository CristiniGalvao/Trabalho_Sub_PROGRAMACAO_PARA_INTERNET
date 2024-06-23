package com.example.resort_unipar.controller;

import com.example.resort_unipar.model.Cliente;
import com.example.resort_unipar.model.Quarto;
import com.example.resort_unipar.model.Reserva;
import com.example.resort_unipar.service.ClienteService;
import com.example.resort_unipar.service.QuartoService;
import com.example.resort_unipar.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;
    private final ClienteService clienteService;
    private final QuartoService quartoService;

    @Autowired
    public ReservaController(ReservaService reservaService, ClienteService clienteService, QuartoService quartoService) {
        this.reservaService = reservaService;
        this.clienteService = clienteService;
        this.quartoService = quartoService;
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

    @PostMapping("/form")
    public String cadastrarReserva(@RequestParam Long clienteId, @RequestParam Integer quartoId,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkin,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime checkout, Model model) {
        Cliente cliente = clienteService.buscarClientePorId(clienteId);
        Quarto quarto = quartoService.buscarQuartoPorId(quartoId);
        if (cliente == null || quarto == null) {
            model.addAttribute("mensagem", "Cliente ou Quarto inválido.");
            return "reserva";
        }
        try {
            Reserva reserva = new Reserva(null, cliente, quarto, checkin, checkout);
            reservaService.cadastrarReserva(reserva);
            model.addAttribute("mensagem", "Reserva cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagem", e.getMessage());
        }
        return "reserva";
    }
}
