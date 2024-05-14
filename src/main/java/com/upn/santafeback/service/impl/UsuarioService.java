package com.upn.santafeback.service.impl;

import com.upn.santafeback.model.Usuario;
import com.upn.santafeback.model.repository.UsuarioRepository;
import com.upn.santafeback.service.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements iUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByDni(String dni) {
        return this.usuarioRepository.findByDni(dni);
    }
}
