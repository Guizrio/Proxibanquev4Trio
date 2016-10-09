package com.proxibanquev4trio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxibanquev4trio.domaine.Compte;

public interface ICompteDao  extends JpaRepository<Compte, Integer>{
	
	
	public List<Compte> findAll();
	
	
	public <S extends Compte> S save(S arg0);
	
	
	

}
