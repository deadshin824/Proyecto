package com.example.Proyecto.Repositorio;

import com.example.Proyecto.Entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioClientes extends JpaRepository<Clientes, Integer> {
}
