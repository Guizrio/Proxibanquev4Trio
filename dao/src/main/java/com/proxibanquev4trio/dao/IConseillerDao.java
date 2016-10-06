package com.proxibanquev4trio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proxibanquev4trio.domaine.Conseiller;


public interface IConseillerDao extends JpaRepository<Conseiller, Integer> {
	
	public List<Conseiller> findById(Long id);
	
	public List<Conseiller> findByLogin(String login);

}
