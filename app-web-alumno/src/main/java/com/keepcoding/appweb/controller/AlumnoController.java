package com.keepcoding.appweb.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keepcoding.appweb.entity.Alumno;
import com.keepcoding.appweb.service.AlumnoService;
 
@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
 
    @Autowired
    private AlumnoService alumnoService;
 
    @GetMapping
    public String listAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoService.findAll());
        model.addAttribute("alumno", new Alumno());
        return "alumnos";
    }
 
    @PostMapping
    public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoService.save(alumno);
        return "redirect:/alumnos";
    }
 
    @GetMapping("/{id}")
    public String showAlumno(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Alumno alumno = alumnoService.findByID(id);
        if (alumno != null) {
	        model.addAttribute("alumno", alumno);
	        return "alumno-details";
        }else {
        	redirectAttributes.addFlashAttribute("error", "Alumno no encontrado");
        }
		return "redirect:/alumnos";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Alumno alumno = alumnoService.findByID(id);
        if (alumno != null) {
	        model.addAttribute("alumno", alumno);
	        return "edit-alumno";
        }else {
        	return "redirect:/alumnos";
        }
		
    }
    
    @PostMapping("/update/{id}")
    public String updateAlumno(@PathVariable("id") Long id, @ModelAttribute Alumno alumno, RedirectAttributes redirectAttributes) {
        alumnoService.save(alumno);
        redirectAttributes.addFlashAttribute("success", "Alumno actualizado correctamente");
        return "redirect:/alumnos";
    }
    
    
 
    @GetMapping("/delete/{id}")
    public String deleteAlumno(@PathVariable("id") Long id) {
        alumnoService.deleteById(id);
        return "redirect:/alumnos";
    }
}