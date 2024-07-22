package com.farmacia.barrio.aplication;

import com.farmacia.barrio.domain.emtity.Barrio;
import com.farmacia.barrio.domain.service.BarrioService;

public class CreateBarrioUseCase {
    private final BarrioService barrioService;
    
    public CreateBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }


    public void execute(Barrio barrio){
        barrioService.createBarrio(barrio);
    }
}
