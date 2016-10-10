package com.proxibanquev4trio.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proxibanquev4trio.domaine.Gerant;

public interface IGerantDao extends JpaRepository<Gerant, Integer> { 
	
	public Gerant findByLogin(String login);

}
