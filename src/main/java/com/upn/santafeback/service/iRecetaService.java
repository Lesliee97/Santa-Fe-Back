package com.upn.santafeback.service;

import com.upn.santafeback.model.Receta;
import com.upn.santafeback.service.dto.RecetaDetalleDTO;
import com.upn.santafeback.service.dto.RecetaResponseDTO;

import java.util.List;

public interface iRecetaService {

    public List<RecetaResponseDTO> findByDniUsuario(String dni);

    public RecetaDetalleDTO findRecetaDetalleById(Long id);
}
