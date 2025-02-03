package com.example.Proyecto.Servicios;

import com.example.Proyecto.Entidades.Pedidos;
import com.example.Proyecto.Repositorio.RepositorioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosPedidos {
    @Autowired
    RepositorioPedidos rPedidos;

    public List<Pedidos> obtenerTodosLosPedidos(){
        return rPedidos.findAll();
    }

    public boolean insertarPedidos(Pedidos p){
        try{
            rPedidos.save(p);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public Pedidos obtenerPorId(Integer id) {
        return rPedidos.findById(id).orElse(null);
    }

    public boolean actualizarPedido(Integer id, Pedidos nuevoPedido) {
        return rPedidos.findById(id).map(pedidoExistente -> {
            pedidoExistente.setPedido(nuevoPedido.getPedido());
            pedidoExistente.setPrecio(nuevoPedido.getPrecio());
            pedidoExistente.setEstado(nuevoPedido.getEstado());

            rPedidos.save(pedidoExistente);
            return true;
        }).orElse(false);
    }




    public void eliminar(Integer id){
        rPedidos.deleteById(id);
    }
}
