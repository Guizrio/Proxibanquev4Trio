package com.proxibanquev4trio.dao;

import com.proxibanquev4trio.domaine.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IConseillerDao extends JpaRepository<Conseiller, Integer> {
	
	public List<Conseiller> findById(Long id);
	
	public List<Conseiller> findByLogin(String login);

}
