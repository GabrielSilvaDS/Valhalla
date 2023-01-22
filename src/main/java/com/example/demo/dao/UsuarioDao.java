package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer>{
	@Query("Select u from Usuario u where u.senha = :senha and u.email = :email")
	Usuario findBySenhaAndEmail(String senha, String email);
	
	
}
