package com.keepcoding.appweb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.appweb.entity.Alumno;
import com.keepcoding.appweb.repository.AlumnoRepository;
import com.keepcoding.appweb.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno findByID(Long id) {
		return alumnoRepository.findById(id).orElse(null);
	}

	@Override
	public Alumno save(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public void deleteById(Long id) {
		alumnoRepository.deleteById(id);
		
	}

}
