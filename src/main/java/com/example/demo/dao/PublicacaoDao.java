package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Publicacao;
import com.example.demo.model.Usuario;

public interface PublicacaoDao extends JpaRepository<Publicacao, Integer>{

	List<Publicacao> findByUser(Usuario user);
	
	List<Publicacao> findByTextoContainingIgnoreCase(String nomeUsuario);

}
