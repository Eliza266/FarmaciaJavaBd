package com.farmacia.ciudad.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.ciudad.domain.emtity.Ciudad;

public interface CiudadService {
    void createCiudad(Ciudad ciudad);
    void updateCiudad(Ciudad ciudad);
    void deleteCiudad(String idCiudad);
    Optional<Ciudad> findCiudadById(String idCiudad);
    List<Ciudad> findAllCiudad();
}
