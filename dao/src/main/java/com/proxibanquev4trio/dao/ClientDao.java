package com.proxibanquev4trio.dao;


import com.proxibanquev4trio.domaine.Client;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Integer> {
	
	public List<Client> findById(Long id);

}
