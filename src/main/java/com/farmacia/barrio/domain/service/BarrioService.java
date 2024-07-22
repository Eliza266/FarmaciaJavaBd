package com.farmacia.barrio.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.barrio.domain.emtity.Barrio;


public interface BarrioService {
    void createBarrio(Barrio barrio);
    void updateBarrio(Barrio barrio);
    void deleteBarrio(String idCiudad);
    Optional<Barrio> findBarrioDtoById(String idCiudad);
    List<Barrio> findAllBarrioDto();
}
