package com.resttechsolutions.ereservation.negocio.repository;

import com.resttechsolutions.ereservation.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    public List<Cliente> findByApellido(String apellido);
    public Cliente findByIdentificacion(String Identificacion);
    @Query("Select c from Cliente c where c.email like %:email")
    public Cliente findByEmail(@Param("email") String email);
}
