package com.keepcoding.appweb.service;

import java.util.List;

import com.keepcoding.appweb.entity.Alumno;

public interface AlumnoService {
	List<Alumno> findAll();
	Alumno findByID(Long id);
	Alumno save(Alumno alumno);
	void deleteById(Long id);

}
