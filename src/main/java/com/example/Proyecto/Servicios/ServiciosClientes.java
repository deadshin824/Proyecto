package com.example.Proyecto.Servicios;

import com.example.Proyecto.Entidades.Administrador;
import com.example.Proyecto.Entidades.Clientes;
import com.example.Proyecto.Repositorio.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosClientes {
    @Autowired
    RepositorioClientes rClientes;

    public List<Clientes> obtenerTodosLosClientes(){
        return rClientes.findAll();
    }

    public boolean insertarClientes(Clientes cliente){
        try{
            rClientes.save(cliente);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public Clientes obtenerPorId(Integer id) {
        return rClientes.findById(id).orElse(null);
    }

    public boolean actualizarCliente(Integer id, Clientes nuevoCliente) {
        return rClientes.findById(id).map(clienteExistente -> {
            clienteExistente.nombreCliente = nuevoCliente.nombreCliente;
            clienteExistente.telefono = nuevoCliente.telefono;
            clienteExistente.correo = nuevoCliente.correo;

            rClientes.save(clienteExistente);
            return true;
        }).orElse(false);
    }


    public void eliminar(Integer id){
        rClientes.deleteById(id);
    }
}
