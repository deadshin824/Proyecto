package com.example.Proyecto.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idPedidos;
    public String Pedido;
    public double precio;
    public String Estado;

    @ManyToOne
    @JoinColumn(name = "idCliente")  // Columna que será la clave foránea
    private Clientes cliente;

    public Pedidos() {
    }

    public Pedidos(Integer idPedidos, String pedido, double precio, String estado, Clientes cliente) {
        this.idPedidos = idPedidos;
        Pedido = pedido;
        this.precio = precio;
        Estado = estado;
        this.cliente = cliente;
    }

    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getPedido() {
        return Pedido;
    }

    public void setPedido(String pedido) {
        Pedido = pedido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}

