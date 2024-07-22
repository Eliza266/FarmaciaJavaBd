package com.farmacia.tipodocumento.aplication;

import com.farmacia.tipodocumento.domain.emtity.TipoDocumento;
import com.farmacia.tipodocumento.domain.service.TipoDocumentoService;

public class CreateTipoUseCase {
    private final TipoDocumentoService tipoDocumentoService;

    public CreateTipoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }
    public void execute(TipoDocumento tipoDocumento){
        tipoDocumentoService.createTipo(tipoDocumento);
    }
}
