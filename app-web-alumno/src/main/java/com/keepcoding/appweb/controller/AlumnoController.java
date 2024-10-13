package com.keepcoding.appweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.appweb.entity.Alumno;
import com.keepcoding.appweb.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping
	public List<Alumno> getAllAlumnos() {
		return alumnoService.findAll();
	}

	@GetMapping("/{id}")
	public Alumno show(@PathVariable Long id) {
		return alumnoService.findByID(id);
	}

	@PostMapping
	public Alumno createAlumno(@RequestBody Alumno alumno) {
		return alumnoService.save(alumno);
	}

	
	
  @PutMapping("/{id}") public ResponseEntity<Alumno> updateAlumno(@PathVariable
  Long id, @RequestBody Alumno alumnoDetails) { Alumno alumno =
  alumnoService.findByID(id); if (alumno == null) { return
  ResponseEntity.notFound().build(); }
  alumno.setNombre(alumnoDetails.getNombre());
  alumno.setApellido(alumnoDetails.getApellido());
  alumno.setTelefono(alumnoDetails.getTelefono());
  alumno.setEmail(alumnoDetails.getEmail());
  alumno.setDni(alumnoDetails.getDni());
  alumno.setFecha_nacimiento(alumnoDetails.getFecha_nacimiento()); return
  ResponseEntity.ok(alumnoService.save(alumno)); }
  
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
      Alumno alumno = alumnoService.findByID(id);
      if (alumno == null) {
          return ResponseEntity.notFound().build();
      }
      alumnoService.deleteById(id);
      return ResponseEntity.ok().build();
  }
	 
		
	/*
	 * @PutMapping("/alumnos/update/{id}") public Alumno alumnoUpdate(@PathVariable
	 * Long id, @RequestBody Alumno alumno) {
	 * 
	 * Alumno alumnoUpdateRequest = alumnoService.findByID(id);
	 * 
	 * alumnoUpdateRequest.setNombre(alumno.getNombre());
	 * alumnoUpdateRequest.setApellido(alumno.getApellido());
	 * alumnoUpdateRequest.setEmail(alumno.getEmail());
	 * alumnoUpdateRequest.setTelefono(alumno.getTelefono());
	 * alumnoUpdateRequest.setDni(alumno.getDni());
	 * alumnoUpdateRequest.setFecha_nacimiento(alumno.getFecha_nacimiento());
	 * 
	 * 
	 * return alumnoService.save(alumnoUpdateRequest); }
	 */
	  
	  
}
