
package com.example.Proyecto.Servicios;

import com.example.Proyecto.Entidades.Administrador;
import com.example.Proyecto.Entidades.Empleados;
import com.example.Proyecto.Repositorio.RepositorioEmpleados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ServiciosEmpleado {
    @Autowired
    RepositorioEmpleados rEmpleados;
    
    public List<Empleados> obtenerTodosLosEmpleados(){

        return rEmpleados.findAll();
    }
    
    public boolean insertarEmpleados(Empleados e){
        try{
           rEmpleados.save(e);
           return true;
        }catch(Exception ex){
            return false;
        }
    }
    public Empleados obtenerPorId(Integer id) {
        return rEmpleados.findById(id).orElse(null);
    }

    public void eliminar(Integer id){
        rEmpleados.deleteById(id);
    }
}
