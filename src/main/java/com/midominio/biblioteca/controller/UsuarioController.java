package com.midominio.biblioteca.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.biblioteca.entity.Usuario;
import com.midominio.biblioteca.services.IUsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping ("/usuario")
public class UsuarioController {

	
	@Autowired
	private IUsuarioService usuarioService;
	
	@ModelAttribute (name = "Biblioteca")
	String tilte () {
		return "Biblioteca";
	}
	
	@GetMapping (value = "/listar")
	public String listaUsuario (Model model) {
		model.addAttribute("title", "Lista de Usuarios");
		model.addAttribute("usuario", usuarioService.findAll());
		
		return "usuario/listar";
	}
	
	@GetMapping ("/form")
	public String crear (Map<String, Object> model) {
		model.put("title", "Formulario de Usuario");
		model.put("titulo", "Formulario de Usuario");
		model.put("usuario", new Usuario());
		
		return "usuario/form";
	}
	
	
	@PostMapping ("/form")
	public String guardar (@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Usuario");
			return "usuario/form";
		}
		usuarioService.save (usuario);
		flash.addFlashAttribute ("success", "Usuario guardado con éxito");
		return "redirect:/usuario/listar";
	}
	
	@GetMapping ("/form/{id}")
	public String actualizar (@PathVariable ("id") Long id, Map<String, Object> model) {
		Usuario usuario = null;
		if ( id > 0)
			usuario = usuarioService.findOne (id);
		else
			return "redirect:/usurio/listar";
		
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");
		
		return "usuario/form";
	}
	
	@GetMapping ("/eliminar/{id}")
	public String eliminar (@PathVariable ("id") Long id, RedirectAttributes flash) {
		
		if (id > 0)
			usuarioService.delete (id);
		flash.addFlashAttribute("warning", "Usuario eliminado con éxito");
		return "redirect:/usuario/listar";
		
	}
	
	
	
	
}
