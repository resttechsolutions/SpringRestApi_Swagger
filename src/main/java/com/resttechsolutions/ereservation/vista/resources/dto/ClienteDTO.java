package com.resttechsolutions.ereservation.vista.resources.dto;

import com.resttechsolutions.ereservation.model.Reserva;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Data
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;
}
