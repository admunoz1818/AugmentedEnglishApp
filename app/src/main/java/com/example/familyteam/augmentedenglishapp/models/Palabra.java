package com.example.familyteam.augmentedenglishapp.models;

/**
 * Created by FamilyTeam on 27/05/2015.
 */
public class Palabra {
    String id;
    String nombre, traduccion, pronunciacion, patron, imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getPronunciacion() {
        return pronunciacion;
    }

    public void setPronunciacion(String pronunciacion) {
        this.pronunciacion = pronunciacion;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
