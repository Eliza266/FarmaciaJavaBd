package com.farmacia.barrio.aplication;

import java.util.Optional;

import com.farmacia.barrio.domain.emtity.Barrio;
import com.farmacia.barrio.domain.service.BarrioService;

public class FindBarrioUseCase {

    private final BarrioService barrioService;

    public FindBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }
    
    public Optional<Barrio> execute(Integer idBarrio){
        return barrioService.findBarrioById(idBarrio);
    }

}
