package com.farmacia.tipodocumento.aplication;

import java.util.Optional;

import com.farmacia.tipodocumento.domain.emtity.TipoDocumento;
import com.farmacia.tipodocumento.domain.service.TipoDocumentoService;

public class FindTipoUseCase {
    private final TipoDocumentoService tipoDocumentoService;


    public FindTipoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }
    

    public Optional<TipoDocumento> execute(Integer idTipo){
        return tipoDocumentoService.findTipoById(idTipo);
    }

}
