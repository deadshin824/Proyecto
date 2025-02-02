package com.example.Proyecto.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer IdAdmin;
    public String NombreAdmin;
    public String UserAdmin;
    public String PasswordAdmin;

    public Administrador() {
    }

    public Administrador(Integer idAdmin, String nombreAdmin, String userAdmin, String passwordAdmin) {
        IdAdmin = idAdmin;
        NombreAdmin = nombreAdmin;
        UserAdmin = userAdmin;
        PasswordAdmin = passwordAdmin;
    }

    public Integer getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        IdAdmin = idAdmin;
    }

    public String getNombreAdmin() {
        return NombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        NombreAdmin = nombreAdmin;
    }

    public String getUserAdmin() {
        return UserAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        UserAdmin = userAdmin;
    }

    public String getPasswordAdmin() {
        return PasswordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        PasswordAdmin = passwordAdmin;
    }
}
