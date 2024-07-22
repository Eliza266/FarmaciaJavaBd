package com.farmacia.tipodocumento.aplication;

import com.farmacia.tipodocumento.domain.service.TipoDocumentoService;

public class DeleteTipoUseCase {
    private final TipoDocumentoService tipoDocumentoService;

    public DeleteTipoUseCase(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    public void execute(Integer idTipo){
        tipoDocumentoService.deleteTipo(idTipo);
    }


}
