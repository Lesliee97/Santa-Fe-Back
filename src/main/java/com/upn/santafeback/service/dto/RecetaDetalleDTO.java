package com.upn.santafeback.service.dto;

import com.upn.santafeback.model.Tratamiento;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RecetaDetalleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private RecetaResponseDTO receta;
    private List<TratamientoDTO> tratamientos;
}
