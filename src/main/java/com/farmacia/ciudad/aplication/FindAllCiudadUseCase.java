package com.farmacia.ciudad.aplication;

import java.util.List;

import com.farmacia.ciudad.domain.emtity.Ciudad;
import com.farmacia.ciudad.domain.service.CiudadService;

public class FindAllCiudadUseCase {
    private final CiudadService ciudadService;

    public FindAllCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public List<Ciudad> execute(){
        return ciudadService.findAllCiudad();
    }
}
