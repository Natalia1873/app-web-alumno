package com.keepcoding.appweb.service;

import org.springframework.stereotype.Service;

import com.keepcoding.appweb.entity.Usuario;

@Service
public interface UsuarioService {
	Usuario findByUsername(String username);
	Usuario save(Usuario usuario);

}
