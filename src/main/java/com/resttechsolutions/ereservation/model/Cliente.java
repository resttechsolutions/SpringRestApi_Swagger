package com.resttechsolutions.ereservation.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findByIdentificacion", query="Select c from Cliente c where c.identificacion = ?1")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(name = "nombre")
    @NotEmpty
    private String nombre;
    @Column(name = "apellido")
    @NotEmpty
    private String apellido;
    @Column(name = "identicifacion")
    @NotEmpty
    private String identificacion;
    @Column(name = "direccion")
    @NotEmpty
    private String direccion;
    @Column(name = "telefono")
    @NotEmpty
    private String telefono;
    @Column(name = "email")
    @NotEmpty
    private String email;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservas;
}
