
package com.example.Proyecto.Services;

import com.example.Proyecto.Entidades.Empleados;
import com.example.Proyecto.Repositories.RepositorioEmpleados;
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
}
