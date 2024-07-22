package com.farmacia.barrio.aplication;
 
import java.util.Optional;

import com.farmacia.barrio.domain.emtity.BarrioDto;
import com.farmacia.barrio.domain.service.BarrioService;

public class FindBarrioDtoUseCase {
    private final BarrioService barrioService;


    public FindBarrioDtoUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }
   public Optional<BarrioDto> execute(Integer idBarrio){
        return barrioService.findBarrioDtoById(idBarrio);
    }


}
