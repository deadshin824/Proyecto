package com.example.Proyecto.Controlador;

import com.example.Proyecto.Entidades.Clientes;
import com.example.Proyecto.Entidades.Pedidos;
import com.example.Proyecto.Servicios.ServiciosPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> InsertarPedidos(@RequestBody Pedidos p){
        boolean pedidoInsertado = sPedidos.insertarPedidos(p);  // Intentar insertar el pedido
        if (pedidoInsertado) {
            return ResponseEntity.ok("Pedido insertado correctamente");  // Mensaje de éxito
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el pedido");  // Mensaje de error
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
    public ResponseEntity<String> actualizarPedido(@PathVariable Integer id, @RequestBody Pedidos nuevoPedido) {
        if (sPedidos.actualizarPedido(id, nuevoPedido)) {
            return ResponseEntity.ok("Pedido actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
        }
    }


    @DeleteMapping("/EliminarPedido/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Integer id) {
        Pedidos pedido = sPedidos.obtenerPorId(id);
        if (pedido != null) {
            sPedidos.eliminar(id);
            return ResponseEntity.ok("Pedido eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado");
        }
    }
}
