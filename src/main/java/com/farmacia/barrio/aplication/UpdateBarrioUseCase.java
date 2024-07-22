package com.farmacia.barrio.aplication;

import com.farmacia.barrio.domain.emtity.Barrio;
import com.farmacia.barrio.domain.service.BarrioService;

public class UpdateBarrioUseCase {
    private final BarrioService barrioService;


    public UpdateBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }
    

    public void execute(Barrio barrio){
        barrioService.updateBarrio(barrio);
    }

}
