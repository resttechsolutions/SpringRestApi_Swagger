package com.resttechsolutions.ereservation.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="reserva")
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    @Column(name = "codigoReserva")
    @NotEmpty
    private String codigoReserva;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaIngReserva")
    @NotEmpty
    private Date fechaIngReserva;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaSalReserva")
    @NotEmpty
    private Date fechaSalReserva;
    @Column(name = "cantidadPersonasReserva")
    @NotEmpty
    private int cantidadPersonasReserva;
    @Column(name = "descripcionReserva")
    @NotEmpty
    private String descripcionReserva;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

}
