package com.farmacia.ciudad.domain.emtity;

public class Ciudad {
    private String idCiudad;
    private String nombre;

    public Ciudad() {
    }

    public Ciudad(String idCiudad, String nombre) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
    }

    public String getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
