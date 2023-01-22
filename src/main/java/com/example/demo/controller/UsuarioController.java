package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired(required = true)
	private UsuarioDao usuarioDao;
	
	@GetMapping("/efetuarCadastro")
	public String efetuarCadastro(Usuario usuario) {
		System.out.println(usuario);
		this.usuarioDao.save(usuario);
		return "index";
	}
	
}
