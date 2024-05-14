package com.upn.santafeback.service.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class RecetaResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String medico;
    private String especialidad;
    private String indicaciones;
    private int cantidadMedicamentos;
    private String dniUsuario;
}
