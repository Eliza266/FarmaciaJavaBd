package com.farmacia.barrio.domain.emtity;

public class Barrio {
    private Integer idBarrio;
    private String nombre;
    private String idCiudad;

    public Barrio() {
    }


    public Barrio(Integer idBarrio, String nombre, String idCiudad) {
        this.idBarrio = idBarrio;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
    }

    public Integer getIdBarrio() {
        return this.idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }



}
