package com.farmacia.barrio.aplication;

import com.farmacia.barrio.domain.service.BarrioService;

public class DeleteBarrioUseCase {
    private final  BarrioService barrioService;


    public DeleteBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }
    public void execute(Integer idBarrio){
       barrioService.deleteBarrio(idBarrio);
    }

}
