package com.example.Proyecto.Controlador;

import com.example.Proyecto.Entidades.Clientes;
import com.example.Proyecto.Servicios.ServiciosClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> InsertarClientes(@RequestBody Clientes cliente) {
        Map<String, String> response = new HashMap<>();
        if (sClientes.insertarClientes(cliente)) {
            response.put("mensaje", "Cliente insertado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Error al insertar el cliente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
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
    public ResponseEntity<Map<String, String>> actualizarCliente(@PathVariable Integer id, @RequestBody Clientes nuevoCliente) {
        Map<String, String> response = new HashMap<>();
        if (sClientes.actualizarCliente(id, nuevoCliente)) {
            response.put("mensaje", "Cliente actualizado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Cliente no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }



    @DeleteMapping("/EliminarCliente/{id}")
    public ResponseEntity<Map<String, String>> eliminarCliente(@PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();
        Clientes cliente = sClientes.obtenerPorId(id);
        if (cliente != null) {
            sClientes.eliminar(id);
            response.put("mensaje", "Cliente eliminado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Cliente no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
