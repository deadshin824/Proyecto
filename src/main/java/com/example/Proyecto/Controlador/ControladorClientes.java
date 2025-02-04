package com.example.Proyecto.Controlador;

import com.example.Proyecto.Entidades.Clientes;
import com.example.Proyecto.Servicios.ServiciosClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class ControladorClientes {
    @Autowired
    ServiciosClientes sClientes;

    @GetMapping("/Saludo")
    public String saludoBienvenida(){
        return "Este es el mensaje de bienvenida";
    }

    @GetMapping("/ListaCompletaClientes")
    public List<Clientes> ListaCompleta(){
        return sClientes.obtenerTodosLosClientes();
    }

    @PostMapping("/InsertarClientes")
    public ResponseEntity<String> InsertarCliente(@RequestBody Clientes a){
        boolean clienteInsertado = sClientes.insertarClientes(a);  // Intentar insertar el cliente
        if (clienteInsertado) {
            return ResponseEntity.ok("Cliente insertado correctamente");  // Mensaje de éxito
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el cliente");  // Mensaje de error
        }
    }


    @GetMapping("/ObtenerCliente/{id}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable Integer id) {
        Clientes cliente = sClientes.obtenerPorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    @PutMapping("/ActualizarCliente/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Integer id, @RequestBody Clientes nuevoCliente) {
        if (sClientes.actualizarCliente(id, nuevoCliente)) {
            return ResponseEntity.ok("Cliente actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }


    @DeleteMapping("/EliminarCliente/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        Clientes cliente = sClientes.obtenerPorId(id);
        if (cliente != null) {
            sClientes.eliminar(id);
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
}
