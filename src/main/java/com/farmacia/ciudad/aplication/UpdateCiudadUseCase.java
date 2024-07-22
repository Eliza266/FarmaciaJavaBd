package com.farmacia.ciudad.aplication;

import com.farmacia.ciudad.domain.emtity.Ciudad;
import com.farmacia.ciudad.domain.service.CiudadService;

public class UpdateCiudadUseCase {
    private final CiudadService ciudadService;

    public UpdateCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(Ciudad ciudad){
        ciudadService.updateCiudad(ciudad);
    }

}
