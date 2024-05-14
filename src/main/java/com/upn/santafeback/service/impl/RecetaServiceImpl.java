package com.upn.santafeback.service.impl;

import com.upn.santafeback.model.Receta;
import com.upn.santafeback.model.Tratamiento;
import com.upn.santafeback.model.repository.RecetaRepository;
import com.upn.santafeback.model.repository.TratamientoRepository;
import com.upn.santafeback.service.dto.RecetaDetalleDTO;
import com.upn.santafeback.service.dto.RecetaResponseDTO;
import com.upn.santafeback.service.dto.TratamientoDTO;
import com.upn.santafeback.service.iRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecetaServiceImpl implements iRecetaService {

    @Autowired
    private RecetaRepository recetaRepo;

    @Autowired
    private TratamientoRepository tratamientoRepo;

    @Override
    public List<RecetaResponseDTO> findByDniUsuario(String dni) {
        List<Receta> recetas = recetaRepo.findByDniUsuario(dni);
        RecetaResponseDTO recetaResponseDTO = new RecetaResponseDTO();
        List<RecetaResponseDTO> response = new ArrayList<>();
        if (!recetas.isEmpty()) {
            recetas.forEach(receta -> {
                recetaResponseDTO.setId(receta.getId());
                recetaResponseDTO.setFechaInicio(receta.getFechaInicio());
                recetaResponseDTO.setFechaFin(receta.getFechaFin());
                recetaResponseDTO.setMedico(receta.getMedico());
                recetaResponseDTO.setEspecialidad(receta.getEspecialidad());
                recetaResponseDTO.setDniUsuario(receta.getIdUsuario().getDni());
                recetaResponseDTO.setCantidadMedicamentos(receta.getTratamientos().size());
                recetaResponseDTO.setIndicaciones(receta.getIndicaciones());
                response.add(recetaResponseDTO);
            });
        }
        return response;
    }

    @Override
    public RecetaDetalleDTO findRecetaDetalleById(Long id) {
        RecetaDetalleDTO recetaDetalleDTO = new RecetaDetalleDTO();
        List<TratamientoDTO> tratamientoDTOs = new ArrayList<>();

        Optional<Receta> receta = recetaRepo.findById(id);
        if (receta.isPresent()) {
            RecetaResponseDTO recetaResponseDTO = new RecetaResponseDTO();
            recetaResponseDTO.setId(receta.get().getId());
            recetaResponseDTO.setFechaInicio(receta.get().getFechaInicio());
            recetaResponseDTO.setFechaFin(receta.get().getFechaFin());
            recetaResponseDTO.setMedico(receta.get().getMedico());
            recetaResponseDTO.setEspecialidad(receta.get().getEspecialidad());
            recetaResponseDTO.setDniUsuario(receta.get().getIdUsuario().getDni());
            recetaResponseDTO.setCantidadMedicamentos(receta.get().getTratamientos().size());
            recetaResponseDTO.setIndicaciones(receta.get().getIndicaciones());

            List<Tratamiento> tratamientos = this.tratamientoRepo.findTratamientoByIdReceta(receta.get());
            if (!tratamientos.isEmpty()) {
                tratamientos.forEach(tratamiento -> {
                    TratamientoDTO tratamientoDTO = new TratamientoDTO();
                    tratamientoDTO.setId(tratamiento.getId());
                    tratamientoDTO.setCantidadDiaria(tratamiento.getCantidadDiaria());
                    tratamientoDTO.setDosis(tratamiento.getDosis());
                    tratamientoDTO.setNombreMecicamento(tratamiento.getIdMedicamento().getNombre());

                    tratamientoDTOs.add(tratamientoDTO);
                });
            }

            recetaDetalleDTO.setReceta(recetaResponseDTO);
            recetaDetalleDTO.setTratamientos(tratamientoDTOs);

            return recetaDetalleDTO;
        }
        return null;
    }
}
