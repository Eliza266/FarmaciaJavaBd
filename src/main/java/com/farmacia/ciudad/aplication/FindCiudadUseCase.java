package com.farmacia.ciudad.aplication;

import java.util.Optional;

import com.farmacia.ciudad.domain.emtity.Ciudad;
import com.farmacia.ciudad.domain.service.CiudadService;

public class FindCiudadUseCase {
    private final CiudadService ciudadService;

    public FindCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public Optional<Ciudad> execute(String idCiudad){
        return ciudadService.findCiudadById(idCiudad);
    }

}
