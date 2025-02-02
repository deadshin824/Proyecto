package com.example.Proyecto.Controlador;

import com.example.Proyecto.Entidades.Administrador;
import com.example.Proyecto.Servicios.ServiciosAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class ControladorAdmin {
    @Autowired
    ServiciosAdmin sAdmin;

    @GetMapping("/Saludo")
    public String saludoBienvenida(){
        return "Este es el mensaje de bienvenida";
    }

    @GetMapping("/ListaCompletaAdmin")
    public List<Administrador> ListaCompleta(){
        return sAdmin.obtenerTodosLosAdmin();
    }

    @PostMapping("/InsertarAdmin")
    public List<Administrador> InsertarAdmin(@RequestBody Administrador a){
        if(sAdmin.insertarAdmins(a)){
            return sAdmin.obtenerTodosLosAdmin();
        }else{
            return null;
        }
    }

}
