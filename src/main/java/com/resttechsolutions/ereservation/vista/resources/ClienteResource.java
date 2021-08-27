package com.resttechsolutions.ereservation.vista.resources;

import com.resttechsolutions.ereservation.model.Cliente;
import com.resttechsolutions.ereservation.negocio.implementations.ClienteImpl;
import com.resttechsolutions.ereservation.vista.resources.dto.ClienteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

    @Autowired
    private ClienteImpl ci;

    @PostMapping
    @ApiOperation(value = "Crear Cliente", notes = " Servicio para crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud inválida"),
            @ApiResponse(code = 500, message = "Se produjo un error interno")
    }
    )
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDTO dto){
        Cliente c = new Cliente();

        c.setNombre(dto.getNombre());
        c.setApellido(dto.getApellido());
        c.setIdentificacion(dto.getIdentificacion());
        c.setDireccion(dto.getDireccion());
        c.setTelefono(dto.getTelefono());
        c.setEmail(dto.getEmail());

        return new ResponseEntity<>(this.ci.createCliente(c), HttpStatus.CREATED);
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Cliente", notes = " Servicio para actualizar un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 500, message = "Se produjo un error interno")
    }
    )
    public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion, ClienteDTO dto){

        Cliente c = this.ci.findByIdentificacion(identificacion);

        if(c == null)
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

        c.setNombre(dto.getNombre());
        c.setApellido(dto.getApellido());
        c.setIdentificacion(dto.getIdentificacion());
        c.setDireccion(dto.getDireccion());
        c.setTelefono(dto.getTelefono());
        c.setEmail(dto.getEmail());

        return new ResponseEntity<>(this.ci.updateCliente(c), HttpStatus.OK);
    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Cliente", notes = " Servicio para eliminar un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 500, message = "Se produjo un error interno")
    }
    )
    public void deleteCliente(@PathVariable("identificacion") String identificacion){
        Cliente c = this.ci.findByIdentificacion(identificacion);

        if(c != null)
            this.ci.deleteCliente(c);
    }

    @GetMapping
    @ApiOperation(value = "Listar Clientes", notes = " Servicio para listar todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Clientes encontrados"),
            @ApiResponse(code = 404, message = "Clientes no encontrados"),
            @ApiResponse(code = 500, message = "Se produjo un error interno")
    })
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(this.ci.readCliente());
    }
}
