package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SenhaController {
	
	@GetMapping("/solicitarSenha")
	public String solicitarSenha() {
		return ("index");
	}
	

}
