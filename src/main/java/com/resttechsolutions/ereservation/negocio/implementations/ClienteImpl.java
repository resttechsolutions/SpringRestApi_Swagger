package com.resttechsolutions.ereservation.negocio.implementations;

import com.resttechsolutions.ereservation.model.Cliente;
import com.resttechsolutions.ereservation.negocio.repository.ClienteRepository;
import com.resttechsolutions.ereservation.negocio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImpl implements ClienteService<Cliente> {

    @Autowired
    private ClienteRepository cr;

    @Override
    @Transactional
    public Cliente createCliente(Cliente cliente) {
        return cr.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> readCliente() {
        return cr.findAll();
    }

    @Override
    @Transactional
    public Cliente updateCliente(Cliente cliente) {
        return cr.save(cliente);
    }

    @Override
    @Transactional
    public void deleteCliente(Cliente cliente) {
        cr.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findByApellido(String apellido) {
        return cr.findByApellido(apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findByIdentificacion(String Identificacion) {
        return cr.findByIdentificacion(Identificacion);
    }

    public Cliente findByEmail(@Param("email") String email){
        return cr.findByEmail(email);
    }
}
