package com.proxibanquev4trio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxibanquev4trio.domaine.Client;

public interface ClientDao extends JpaRepository<Client, Integer> {
	
	public List<Client> getClientById(Long id);

}
