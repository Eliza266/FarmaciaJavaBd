package com.farmacia;

import com.farmacia.barrio.aplication.CreateBarrioUseCase;
import com.farmacia.barrio.aplication.DeleteBarrioUseCase;
import com.farmacia.barrio.aplication.FindAllBarrioDtoUseCase;
import com.farmacia.barrio.aplication.FindBarrioDtoUseCase;
import com.farmacia.barrio.aplication.FindBarrioUseCase;
import com.farmacia.barrio.aplication.UpdateBarrioUseCase;
import com.farmacia.barrio.domain.service.BarrioService;
import com.farmacia.barrio.infrastructure.BarrioRepository;
import com.farmacia.barrio.infrastructure.BarrioUi;
import com.farmacia.ciudad.aplication.CreateCiudadUseCase;
import com.farmacia.ciudad.aplication.DeleteCiudadUseCase;
import com.farmacia.ciudad.aplication.FindAllCiudadUseCase;
import com.farmacia.ciudad.aplication.FindCiudadUseCase;
import com.farmacia.ciudad.aplication.UpdateCiudadUseCase;
import com.farmacia.ciudad.domain.service.CiudadService;
import com.farmacia.ciudad.infrastructure.CiudadRepository;
import com.farmacia.ciudad.infrastructure.CiudadUi;
import com.farmacia.tipodocumento.aplication.CreateTipoUseCase;
import com.farmacia.tipodocumento.aplication.DeleteTipoUseCase;
import com.farmacia.tipodocumento.aplication.FindAllTipoUseCase;
import com.farmacia.tipodocumento.aplication.FindTipoUseCase;
import com.farmacia.tipodocumento.aplication.UpdateTipoUseCase;
import com.farmacia.tipodocumento.domain.service.TipoDocumentoService;
import com.farmacia.tipodocumento.infrastructure.TipoRepository;
import com.farmacia.tipodocumento.infrastructure.TipoUi;

// dominio : entidad
// dominio : servicio
// aplicacion: use case xd
// infrastructura : interfas de usuario Ui
// infrastructura : repository
//!No olvidar actualizar constructor del Ui

public class Main {
    public static void main(String[] args) {

        // ---------------CIUDAD-----------------
        // CiudadService ciudadService = new CiudadRepository();
        // CreateCiudadUseCase createCiudadUseCase = new CreateCiudadUseCase(ciudadService);
        // FindCiudadUseCase findCiudadUseCase = new FindCiudadUseCase(ciudadService);
        // UpdateCiudadUseCase updateCiudadUseCase = new UpdateCiudadUseCase(ciudadService);
        // DeleteCiudadUseCase deleteCiudadUseCase = new DeleteCiudadUseCase(ciudadService);
        // FindAllCiudadUseCase findAllCiudadUseCase = new FindAllCiudadUseCase(ciudadService);

        // CiudadUi ciudadUi = new CiudadUi(createCiudadUseCase, findCiudadUseCase,updateCiudadUseCase, deleteCiudadUseCase, findAllCiudadUseCase);
        //ciudadUi.createCiudad();
        // ciudadUi.findCiudad();
        //ciudadUi.updateCiudad();
        //ciudadUi.deleteCiudad();
        //ciudadUi.findAllCiudad();

        //----------------------TIPO--------------
        // TipoDocumentoService tipoDocumentoService = new TipoRepository();
        // CreateTipoUseCase createTipoUseCase = new CreateTipoUseCase(tipoDocumentoService);
        // FindTipoUseCase findTipoUseCase = new FindTipoUseCase(tipoDocumentoService);
        // DeleteTipoUseCase deleteTipoUseCase = new DeleteTipoUseCase(tipoDocumentoService);
        // UpdateTipoUseCase updateTipoUseCase = new UpdateTipoUseCase(tipoDocumentoService);
        // FindAllTipoUseCase findAllTipoUseCase = new FindAllTipoUseCase(tipoDocumentoService);
        
        // TipoUi tipoUi = new TipoUi(createTipoUseCase, findTipoUseCase, updateTipoUseCase, deleteTipoUseCase, findAllTipoUseCase);
        // tipoUi.createTipo();
        // tipoUi.findTipo();
        // tipoUi.deleteTipo();
        // tipoUi.updateTipo();
        // tipoUi.findAllTipo();

        //--------------------Barrio---------------------------
        BarrioService barrioService = new BarrioRepository();
        CreateBarrioUseCase createBarrioUseCase = new CreateBarrioUseCase(barrioService);
        FindBarrioUseCase findBarrioUseCase = new FindBarrioUseCase(barrioService);
        UpdateBarrioUseCase updateBarrioUseCase = new UpdateBarrioUseCase(barrioService);
        DeleteBarrioUseCase deleteBarrioUseCase = new DeleteBarrioUseCase(barrioService);
        FindBarrioDtoUseCase findBarrioDtoUseCase = new FindBarrioDtoUseCase(barrioService);
        FindAllBarrioDtoUseCase findAllBarrioDtoUseCase = new FindAllBarrioDtoUseCase(barrioService);
        BarrioUi barrioUi = new BarrioUi(createBarrioUseCase, findBarrioDtoUseCase, findBarrioUseCase, updateBarrioUseCase, deleteBarrioUseCase, findAllBarrioDtoUseCase);
        //barrioUi.createBarrio();
        //barrioUi.findBarrio();
        //barrioUi.updateBarrio();
        //barrioUi.deleteBarrio();
        //barrioUi.findBarrioDto();
        barrioUi.findAllBarrioDto();
        
        


    }
}