package com.example.familyteam.augmentedenglishapp.models;

/**
 * Created by FamilyTeam on 26/05/2015.
 */
public class Usuario {
    String id;
    String nombre, correo, contrasena;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
