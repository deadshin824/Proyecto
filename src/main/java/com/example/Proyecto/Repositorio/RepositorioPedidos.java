package com.example.Proyecto.Repositorio;

import com.example.Proyecto.Entidades.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPedidos extends JpaRepository<Pedidos, Integer> {
}
