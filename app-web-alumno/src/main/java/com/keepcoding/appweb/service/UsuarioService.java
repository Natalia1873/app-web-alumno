package com.keepcoding.appweb.service;

import com.keepcoding.appweb.entity.Usuario;

public interface UsuarioService {
	Usuario findByUsername(String username);
	Usuario save(Usuario usuario);

}
