package com.midominio.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping ({"/", "/home", ""})
	public String m (Model model) {
		
			
		
		return "home";
	}
	
}
