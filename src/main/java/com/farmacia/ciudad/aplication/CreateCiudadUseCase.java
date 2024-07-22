package com.farmacia.ciudad.aplication;

import com.farmacia.ciudad.domain.emtity.Ciudad;
import com.farmacia.ciudad.domain.service.CiudadService;

public class CreateCiudadUseCase {
    private final CiudadService ciudadService;

    public CreateCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(Ciudad ciudad){
        ciudadService.createCiudad(ciudad);
    }
}
