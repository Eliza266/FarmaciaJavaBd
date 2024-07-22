package com.farmacia.barrio.domain.emtity;

public class BarrioDto extends Barrio{
    private String nombreCiudad;

    public BarrioDto() {
    }

    public BarrioDto(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public BarrioDto(Integer idBarrio, String nombre, String idCiudad, String nombreCiudad) {
        super(idBarrio, nombre, idCiudad);
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

}
