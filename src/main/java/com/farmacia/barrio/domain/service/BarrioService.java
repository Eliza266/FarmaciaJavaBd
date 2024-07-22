package com.farmacia.barrio.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.barrio.domain.emtity.Barrio;
import com.farmacia.barrio.domain.emtity.BarrioDto;


public interface BarrioService {
    void createBarrio(Barrio barrio);
    void updateBarrio(Barrio barrio);
    void deleteBarrio(Integer idBarrio);
    Optional<BarrioDto> findBarrioDtoById(Integer idBarrio);
    Optional<Barrio> findBarrioById(Integer idBarrio);
    List<BarrioDto> findAllBarrioDto();
}
