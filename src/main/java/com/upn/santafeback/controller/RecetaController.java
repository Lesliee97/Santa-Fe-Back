package com.upn.santafeback.controller;

import com.upn.santafeback.service.dto.RecetaDetalleDTO;
import com.upn.santafeback.service.dto.RecetaResponseDTO;
import com.upn.santafeback.service.iRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/recetas")
public class RecetaController {
    @Autowired
    private iRecetaService recetaService;

    @GetMapping(value = "recetasByDni/{dni}")
    public ResponseEntity<Object> getRecetasByDni(@PathVariable String dni) {
        final List<RecetaResponseDTO> response = this.recetaService.findByDniUsuario(dni);
        return ResponseEntity.ok(!response.isEmpty() ? response : "No se encontraron recetas para el usuario buscado");
    }

    @GetMapping(value = "detalleRecetasById/{id}")
    public ResponseEntity<Object> detalleRecetasById(@PathVariable Long id) {
        final RecetaDetalleDTO response = this.recetaService.findRecetaDetalleById(id);
        return ResponseEntity.ok(response != null ? response : "No se encontro receta con el ID indicado: " + id);
    }
}
