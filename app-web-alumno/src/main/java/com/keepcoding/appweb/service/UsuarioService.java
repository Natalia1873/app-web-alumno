package com.keepcoding.appweb.service;

import java.util.List;
import com.keepcoding.appweb.entity.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario findByUsername(String username);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}

