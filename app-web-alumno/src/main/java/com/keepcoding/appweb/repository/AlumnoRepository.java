package com.keepcoding.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.appweb.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}