package com.farmacia.ciudad.aplication;

import com.farmacia.ciudad.domain.service.CiudadService;

public class DeleteCiudadUseCase {
    private final CiudadService ciudadService;

    public DeleteCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }
    public void execute(String idCiudad){
       ciudadService.deleteCiudad(idCiudad);
    }

}
