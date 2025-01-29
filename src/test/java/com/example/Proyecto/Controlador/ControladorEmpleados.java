
package com.example.Proyecto.Controlador;

import com.example.Proyecto.Entidades.Empleados;
import com.example.Proyecto.Services.ServiciosEmpleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Empleados")
public class ControladorEmpleados {
     @Autowired 
    ServiciosEmpleado sEmpleado;
    
    @GetMapping("/Saludo")
    public String saludoBienvenida(){
        return "Este es el mensaje de bienvenida";
    }
    
    @GetMapping("/ListaCompletaEmpleados")
    public List<Empleados> ListaCompleta(){
        return sEmpleado.obtenerTodosLosEmpleados();
    }
     @PostMapping("/InsertarEmpleado")
    public List<Empleados> InsertarCliente(@RequestBody Empleados e){
        if(sEmpleado.insertarEmpleados(e)){
           return sEmpleado.obtenerTodosLosEmpleados();
   }else{
    return null;
   }
    }
}
