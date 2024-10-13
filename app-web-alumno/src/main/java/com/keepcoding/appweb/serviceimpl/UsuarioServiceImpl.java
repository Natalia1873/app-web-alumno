package com.keepcoding.appweb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.appweb.entity.Usuario;
import com.keepcoding.appweb.repository.UsuarioRepository;
import com.keepcoding.appweb.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	
	@Override
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
