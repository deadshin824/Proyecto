package com.example.Proyecto.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idEmpleado;
    public String NombreCompleto;
    public String User;
    public String Password;

    public Empleados() {
    }

    public Empleados(Integer idEmpleado, String nombreCompleto, String user, String password) {
        this.idEmpleado = idEmpleado;
        NombreCompleto = nombreCompleto;
        User = user;
        Password = password;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
