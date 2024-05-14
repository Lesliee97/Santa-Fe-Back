package com.upn.santafeback.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TratamientoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombreMecicamento;
    private int cantidadDiaria;
    private BigDecimal dosis;
}
