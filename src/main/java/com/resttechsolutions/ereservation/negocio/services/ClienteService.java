package com.resttechsolutions.ereservation.negocio.services;

import com.resttechsolutions.ereservation.model.Cliente;
import com.resttechsolutions.ereservation.negocio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClienteService<T> {

    public Cliente createCliente(T t);
    public List<T> readCliente();
    public Cliente updateCliente(T t);
    public void deleteCliente(T t);
    public List<Cliente> findByApellido(String apellido);
    public Cliente findByIdentificacion(String Identificacion);
    public Cliente findByEmail(@Param("email") String email);
}
