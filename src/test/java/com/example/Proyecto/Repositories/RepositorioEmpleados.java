package com.example.Proyecto.Repositories;

import com.example.Proyecto.Entidades.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioEmpleados extends JpaRepository<Empleados, Long>{
    
}
