package com.keepcoding.appweb.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@Column(nullable = false, length = 50)
	private String apellido;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false, length = 50, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String dni;
	
	@Column(nullable = false)
	private LocalDate fecha_nacimiento;
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
