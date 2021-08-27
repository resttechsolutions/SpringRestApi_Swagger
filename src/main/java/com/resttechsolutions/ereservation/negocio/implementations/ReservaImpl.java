package com.resttechsolutions.ereservation.negocio.implementations;

import com.resttechsolutions.ereservation.model.Cliente;
import com.resttechsolutions.ereservation.model.Reserva;
import com.resttechsolutions.ereservation.negocio.repository.ReservaRepository;
import com.resttechsolutions.ereservation.negocio.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReservaImpl implements ReservaService<Reserva> {

    @Autowired
    private ReservaRepository rr;

    @Override
    @Transactional
    public Reserva createReserva(Reserva reserva) {
        return rr.save(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> readReserva() {
        return rr.findAll();
    }

    @Override
    @Transactional
    public Reserva updateReserva(Reserva reserva) {
        return rr.save(reserva);
    }

    @Override
    @Transactional
    public void deleteReserva(Reserva reserva) {
        rr.delete(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> find(Date fechaInicio, Date fechaSalida) {
        return rr.find(fechaInicio, fechaSalida);
    }

    public List<Reserva> findByCliente(Cliente cliente){
        return rr.findByCliente(cliente);
    }
    public Reserva findByCodigoReserva(String codigoReserva){
        return rr.findByCodigoReserva(codigoReserva);
    }
}
