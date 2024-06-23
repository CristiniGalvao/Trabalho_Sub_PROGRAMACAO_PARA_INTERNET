package com.example.resort_unipar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clienteCpf;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private StatusReserva status;

    public Reserva(Long clienteId, Long quartoId,String clienteCpf, LocalDateTime checkin, LocalDateTime checkout) {
        if (checkout.isBefore(checkin.plusDays(2))) {
            throw new IllegalArgumentException("A reserva deve ser de no mínimo 2 dias.");
        }
        this.clienteCpf = clienteCpf;
        this.checkin = checkin;
        this.checkout = checkout;
        this.status = StatusReserva.PENDENTE;
    }


    public Reserva(Integer id, Long clienteId, Long quartoId, LocalDateTime checkinDate, LocalDateTime checkoutDate) {
    }

    public Reserva() {

    }

    public Reserva(Long o, Cliente cliente, Quarto quarto, LocalDateTime checkin, LocalDateTime checkout) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
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
