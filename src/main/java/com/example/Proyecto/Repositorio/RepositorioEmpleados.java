package com.example.Proyecto.Repositorio;

import com.example.Proyecto.Entidades.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioEmpleados extends JpaRepository<Empleados, Long>{
    
}
