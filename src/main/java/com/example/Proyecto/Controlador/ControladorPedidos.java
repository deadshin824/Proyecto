package com.example.Proyecto.Controlador;

import com.example.Proyecto.Entidades.Clientes;
import com.example.Proyecto.Entidades.Pedidos;
import com.example.Proyecto.Servicios.ServiciosPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Pedidos")
public class ControladorPedidos {
    @Autowired
    ServiciosPedidos sPedidos;

    @GetMapping("/Saludo")
    public String saludoBienvenida(){
        return "Este es el mensaje de bienvenida";
    }

    @GetMapping("/ListaCompletaPedidos")
    public List<Pedidos> ListaCompleta(){
        return sPedidos.obtenerTodosLosPedidos();
    }

    @PostMapping("/InsertarPedidos")
    public ResponseEntity<Map<String, String>> InsertarPedidos(@RequestBody Pedidos pedido) {
        Map<String, String> response = new HashMap<>();
        boolean pedidoInsertado = sPedidos.insertarPedidos(pedido);  // Intentar insertar el pedido

        if (pedidoInsertado) {
            response.put("mensaje", "Pedido insertado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Error al insertar el pedido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }



    @GetMapping("/ObtenerPedido/{id}")
    public ResponseEntity<?> obtenerPedidoPorId(@PathVariable Integer id) {
        Pedidos pedido = sPedidos.obtenerPorId(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
        }
    }

    @PutMapping("/ActualizarPedido/{id}")
    public ResponseEntity<Map<String, String>> actualizarPedido(@PathVariable Integer id, @RequestBody Pedidos nuevoPedido) {
        Map<String, String> response = new HashMap<>();
        boolean pedidoActualizado = sPedidos.actualizarPedido(id, nuevoPedido);  // Intentar actualizar el pedido

        if (pedidoActualizado) {
            response.put("mensaje", "Pedido actualizado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Pedido no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }



    @DeleteMapping("/EliminarPedido/{id}")
    public ResponseEntity<Map<String, String>> eliminarPedido(@PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();
        Pedidos pedido = sPedidos.obtenerPorId(id);  // Obtener el pedido por ID
        if (pedido != null) {
            sPedidos.eliminar(id);  // Eliminar el pedido
            response.put("mensaje", "Pedido eliminado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Pedido no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
