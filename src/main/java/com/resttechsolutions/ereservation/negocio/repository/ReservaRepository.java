package com.resttechsolutions.ereservation.negocio.repository;

import com.resttechsolutions.ereservation.model.Cliente;
import com.resttechsolutions.ereservation.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {


    @Query("Select r from Reserva r where r.cliente =:cliente")
    public List<Reserva> findByCliente(Cliente cliente);
    public Reserva findByCodigoReserva(String codigoReserva);
    @Query("Select r from Reserva r where r.fechaIngReserva =: fechaInicio and r.fechaSalReserva =: fechaSalida")
    public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);

}
