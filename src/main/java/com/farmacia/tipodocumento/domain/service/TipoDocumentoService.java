package com.farmacia.tipodocumento.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.tipodocumento.domain.emtity.TipoDocumento;

public interface TipoDocumentoService {
    void createTipo(TipoDocumento tipoDocumento);
    void updateTipo(TipoDocumento tipoDocumento);
    void deleteTipo(Integer idTipo);
    Optional<TipoDocumento> findTipoById(Integer idTipo);
    List<TipoDocumento> findAllTipo();
}
