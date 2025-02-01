package com.example.Proyecto.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idEmpleado;
    private String NombreCompleto;
    private String User;
    private String Password;

    public Empleados() {
    }

    public Empleados(long idEmpleado, String NombreCompleto, String User, String Password) {
        this.idEmpleado = idEmpleado;
        this.NombreCompleto = NombreCompleto;
        this.User = User;
        this.Password = Password;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public String getUser() {
        return User;
    }

    public String getPassword() {
        return Password;
    }

   
    
    
}
