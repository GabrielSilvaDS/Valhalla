package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.PublicacaoDao;
import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.Publicacao;
import com.example.demo.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDao dao;
	
	@Autowired(required = true)
	private PublicacaoDao publicacaoDao;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal(HttpSession session, Model model) {
		Usuario usuario =(Usuario)session.getAttribute("usuarioLogado");
		if (model.getAttribute("publi") == null) {
			model.addAttribute("publi", new Publicacao());
		}
		model.addAttribute("usuario", usuario);
		model.addAttribute("lista", publicacaoDao.findAll());
		return "principal";
	}
	
	@PostMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, RedirectAttributes ra, HttpSession session) {
		Usuario usu= dao.findBySenhaAndEmail(usuario.getSenha(), usuario.getEmail());
		if(usu != null) { 
			session.setAttribute("usuarioLogado", usu);
			return "redirect:/paginaPrincipal";
		} else {
			ra.addFlashAttribute("mensagem", "por favor, insira um usuário válido!");
			return "redirect:/index";
		}
	}
	@GetMapping("/cadastrarUsuario")
	public String cadastrarUsuario(Usuario cadastro) {
		return "usuario";
	}
	@GetMapping("/esqueciSenha")
	public String esqueciSenha(Usuario cadastro) {
		return "senha";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
