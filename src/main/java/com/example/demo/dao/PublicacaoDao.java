package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Publicacao;

public interface PublicacaoDao extends JpaRepository<Publicacao, Integer>{

}
