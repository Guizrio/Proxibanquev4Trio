package com.proxibanquev4trio.dao;


import com.proxibanquev4trio.domaine.Client;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proxibanquev4trio.domaine.Conseiller;

public interface IClientDao extends JpaRepository<Client, Integer> {
	
	public Client findById(Long id);
	
	public List<Client> findByConseiller(Conseiller conseiller);

}
