package com.example.Proyecto.Servicios;

import com.example.Proyecto.Entidades.Administrador;
import com.example.Proyecto.Repositorio.RepositorioAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosAdmin {
    @Autowired
    RepositorioAdministrador rAdmin;

    public List<Administrador> obtenerTodosLosAdmin(){
        return rAdmin.findAll();
    }

    public boolean insertarAdmins(Administrador a){
        try{
            rAdmin.save(a);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public Administrador obtenerPorId(Integer id) {
        return rAdmin.findById(id).orElse(null);
    }

    public void eliminar(Integer id){
        rAdmin.deleteById(id);
    }
}
