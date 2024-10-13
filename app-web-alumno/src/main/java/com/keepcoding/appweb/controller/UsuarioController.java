package com.keepcoding.appweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.appweb.entity.Usuario;
import com.keepcoding.appweb.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/register")
	public ResponseEntity<Usuario> registerUser(@RequestBody Usuario usuario) {
		Usuario savedUsuario = usuarioService.save(usuario);
		return ResponseEntity.ok(savedUsuario);
    }

}