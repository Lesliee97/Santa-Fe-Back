package com.upn.santafeback.controller;

import com.upn.santafeback.model.Usuario;
import com.upn.santafeback.service.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private iUsuarioService usuarioService;

    @GetMapping(value = "usuarioByDni/{dni}")
    public ResponseEntity<Object> getUsuarioByDni(@PathVariable String dni) {
        final Usuario response = this.usuarioService.findByDni(dni);
        return ResponseEntity.ok(response);
    }
}
