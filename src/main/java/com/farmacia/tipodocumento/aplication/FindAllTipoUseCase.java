package com.farmacia.tipodocumento.aplication;

import java.util.List;

import com.farmacia.tipodocumento.domain.emtity.TipoDocumento;
import com.farmacia.tipodocumento.domain.service.TipoDocumentoService;

public class FindAllTipoUseCase {

    private TipoDocumentoService tipoDocumentoService;


    public FindAllTipoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }
    

    public List<TipoDocumento> execute(){
        return tipoDocumentoService.findAllTipo();
    }

}
