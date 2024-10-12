package com.keepcoding.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.appweb.entity.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);

}
