package com.resttechsolutions.ereservation.negocio.services;

import com.resttechsolutions.ereservation.model.Cliente;
import com.resttechsolutions.ereservation.model.Reserva;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservaService<T> {

    public Reserva createReserva(T t);
    public List<Reserva> readReserva();
    public Reserva updateReserva(T t);
    public void deleteReserva(T t);
    public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);
    public List<Reserva> findByCliente(Cliente cliente);
    public Reserva findByCodigoReserva(String codigoReserva);
}
