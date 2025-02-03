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

    public boolean insertarClientes(Clientes a){
        try{
            rClientes.save(a);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public Clientes obtenerPorId(Integer id) {
        return rClientes.findById(id).orElse(null);
    }

    public void eliminar(Integer id){
        rClientes.deleteById(id);
    }
}
