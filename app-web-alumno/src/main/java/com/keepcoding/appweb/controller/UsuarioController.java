package com.keepcoding.appweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keepcoding.appweb.entity.Usuario;
import com.keepcoding.appweb.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("usuario", new Usuario());
        return "usuarios";
    }

    @PostMapping
    public String saveUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/{id}")
    public String showUsuario(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuario-details";
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/usuarios";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "edit-usuario";
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/update/{id}")
    public String updateUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String registerUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            usuario.setActivo(true); // Establecer el usuario como activo por defecto
            usuarioService.save(usuario);
            redirectAttributes.addFlashAttribute("success", "Usuario registrado exitosamente");
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar el usuario: " + e.getMessage());
            return "redirect:/usuarios/register";
        }
    }
}
