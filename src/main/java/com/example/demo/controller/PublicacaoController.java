package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.PublicacaoDao;
import com.example.demo.model.Publicacao;
import com.example.demo.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class PublicacaoController {

	@Autowired(required = true)
	private PublicacaoDao publicacaoDao;
	
	private Date getDataHora() throws ParseException {
		var sd = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		var dt = sd.format(Calendar.getInstance().getTime());
		var dataHora = sd.parse(dt);
		return new java.sql.Date(dataHora.getTime());
	}
	
	@PostMapping("/salvarPublicacao")
	public String salvarPublicacao(@ModelAttribute Publicacao publicacao,HttpSession session,Model model) throws ParseException {
		Usuario usuario =(Usuario)session.getAttribute("usuarioLogado");
		publicacao.setUser(usuario);
		publicacao.setCurtida(0);
		publicacao.setDataPublicacao(this.getDataHora());
		this.publicacaoDao.save(publicacao);
		return "redirect:/paginaPrincipal";
	}
	
	@PostMapping("/salvarEdicaoPublicacao")
	public String salvarEdicaoPublicacao(@ModelAttribute Publicacao publicacao,HttpSession session,Model model) throws ParseException {
		Usuario usuario =(Usuario)session.getAttribute("usuarioLogado");
		publicacao.setDataPublicacao(this.getDataHora());
		this.publicacaoDao.save(publicacao);
		return "redirect:/paginaPrincipal";
	}
	
	@GetMapping("/listarTodasPublicacoes")
	public String listarTodasPublicacoes(Integer id, Model model) {
		model.addAttribute("lista", this.publicacaoDao.findAll(Sort.by("dataPublicacao")));
		return "redirect:/paginaPrincipal";
	}
	
	@GetMapping("/editarPublicacao")
	public String editarPublicacao(Integer id,Model model,HttpSession session) {
		Usuario usuario =(Usuario)session.getAttribute("usuarioLogado");
		model.addAttribute("usuario", usuario);
		model.addAttribute("publi",this.publicacaoDao.findById(id));
		return "editarPublicacao";
	}
	
	@GetMapping("/removerPublicacao")
	public String removerPublicacao(Integer id) {
		this.publicacaoDao.deleteById(id);
		return "redirect:/paginaPrincipal";
	}
	
	
}
