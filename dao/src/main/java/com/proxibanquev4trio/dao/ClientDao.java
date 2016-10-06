package com.proxibanquev4trio.dao;


import com.proxibanquev4trio.domaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDao extends JpaRepository<Client, Integer> {
	
	public List<Client> findClientById(Long id);

}
