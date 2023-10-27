package com.midominio.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.biblioteca.dao.ILibroDao;
import com.midominio.biblioteca.entity.Libro;
import com.midominio.biblioteca.services.ILibroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping ("/libro")
public class LibroController {

	@Autowired
	//private ILibroDao libroDao;
	private ILibroService libroService;
	
	@ModelAttribute (name = "Biblioteca")
	String tilte() {
		return "Biblioteca";
	}
	
	@GetMapping(value = "/listar")
	public String listaLibro(Model model) {
		model.addAttribute("title", "Lista de libros");
		model.addAttribute("libro", libroService.findAll());
			
		return"libro/listar";
	}
	
	@GetMapping ("/form")
	public String crear (Map<String, Object> model) {
		model.put("title", "Formulario de Libro");
		model.put("titulo", "Formulario de Libro");
		model.put("libro", new Libro());
		
		return "libro/form";
	}
	
	@PostMapping ("/form")
	public String guardar(@Valid Libro libro, BindingResult result, Model model, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Libro");
			return "libro/form";
		}
		
		libroService.save(libro);
		flash.addFlashAttribute ("success", "Libro guardado con éxito");
		return "redirect:/libro/listar";
	}
	
	@GetMapping ("/form/{id}")
	public String actualizar (@PathVariable ("id") Long id, Map<String, Object> model) {
		Libro libro = null;
		if ( id > 0) 
			libro = libroService.findOne(id);
		else 
			return "redirect:/libro/listar";
		
		model.put ("libro", libro);
		model.put ("titulo", "Editar Libro");
		
		return "libro/form";
	}
	

	@GetMapping ("/eliminar/{id}")
	public String eliminar (@PathVariable("id") Long id, RedirectAttributes flash) {
		if (id > 0)
			libroService.delete(id);
		flash.addFlashAttribute("warning", "Libro eliminado con éxito");
		return "redirect:/libro/listar";
	}
	
	@GetMapping ("/autor/{autor}")
	public String listaPorAutor (@PathVariable("autor") String autor, Model model) {
		
		
		
		
		return "libro/form";
	}
}
