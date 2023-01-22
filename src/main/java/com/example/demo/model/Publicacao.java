package com.example.demo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Publicacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataPublicacao; 
	private String texto;
	private Integer curtida;
	//private Comentario comentario;
	@ManyToOne(fetch = FetchType.LAZY)
    private Usuario user;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getCurtida() {
		return curtida;
	}
	public void setCurtida(Integer curtida) {
		this.curtida = curtida;
	}
	
	
}

