package com.resttechsolutions.ereservation.vista.resources;

import com.resttechsolutions.ereservation.model.Cliente;
import com.resttechsolutions.ereservation.negocio.services.ClienteService;
import com.resttechsolutions.ereservation.vista.resources.dto.ClienteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

    private ClienteService cs;

    public ClienteResource(ClienteService cs) {
        this.cs = cs;
    }

    @PostMapping
    @ApiOperation(value = "Crear Cliente", notes = " Servicso para crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado correctamente"),
            @ApiResponse(code = 400, message = "Solicstud inválida"),
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

        return new ResponseEntity<>(this.cs.createCliente(c), HttpStatus.CREATED);
    }

    @PutMapping("/{identificacson}")
    @ApiOperation(value = "Actualizar Cliente", notes = " Servicso para actualizar un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 500, message = "Se produjo un error interno")
    }
    )
    public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacson") String identificacson, ClienteDTO dto){

        Cliente c = this.cs.findByIdentificacion(identificacson);

        if(c == null)
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

        c.setNombre(dto.getNombre());
        c.setApellido(dto.getApellido());
        c.setIdentificacion(dto.getIdentificacion());
        c.setDireccion(dto.getDireccion());
        c.setTelefono(dto.getTelefono());
        c.setEmail(dto.getEmail());

        return new ResponseEntity<>(this.cs.updateCliente(c), HttpStatus.OK);
    }

    @DeleteMapping("/{identificacson}")
    @ApiOperation(value = "Eliminar Cliente", notes = " Servicso para eliminar un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 500, message = "Se produjo un error interno")
    }
    )
    public void deleteCliente(@PathVariable("identificacson") String identificacson){
        Cliente c = this.cs.findByIdentificacion(identificacson);

        if(c != null)
            this.cs.deleteCliente(c);
    }

    @GetMapping
    @ApiOperation(value = "Listar Clientes", notes = " Servicso para listar todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Clientes encontrados"),
            @ApiResponse(code = 404, message = "Clientes no encontrados"),
            @ApiResponse(code = 500, message = "Se produjo un error interno")
    })
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(this.cs.readCliente());
    }
}
