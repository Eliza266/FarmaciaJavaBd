package com.farmacia.tipodocumento.aplication;

import com.farmacia.tipodocumento.domain.emtity.TipoDocumento;
import com.farmacia.tipodocumento.domain.service.TipoDocumentoService;

public class UpdateTipoUseCase {
    private final TipoDocumentoService tipoDocumentoService;

    public UpdateTipoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    public void execute(TipoDocumento tipoDocumento){
        tipoDocumentoService.updateTipo(tipoDocumento);
    }

}
