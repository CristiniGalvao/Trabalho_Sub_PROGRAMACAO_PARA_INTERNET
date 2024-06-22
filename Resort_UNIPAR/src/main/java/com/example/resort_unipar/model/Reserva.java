package com.example.resort_unipar.model;

import java.time.LocalDateTime;

public class Reserva {
    private Integer id;
    private Cliente cliente;
    private Quarto quarto;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private StatusReserva status;

    public Reserva(Integer id,Cliente cliente, Quarto quarto, LocalDateTime checkin, LocalDateTime checkout) {
        if (cliente.getIdade() < 18) {
            throw new IllegalArgumentException("O cliente deve ser maior de idade.");
        }
        if (checkout.isBefore(checkin.plusDays(2))) {
            throw new IllegalArgumentException("A reserva deve ser de no mínimo 2 dias.");
        }
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.checkin = checkin;
        this.checkout = checkout;
        this.status = StatusReserva.PENDENTE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }
}
