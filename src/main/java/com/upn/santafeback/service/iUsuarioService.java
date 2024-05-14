package com.upn.santafeback.service;

import com.upn.santafeback.model.Usuario;

public interface iUsuarioService {
    public Usuario findByDni(String dni);
}
