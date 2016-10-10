package com.proxibanquev4trio.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.proxibanquev4trio.dao.IClientDao;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Conseiller;

@Component
public class ClientService implements IClientService {
	
	@Inject
	IClientDao clientdao;
	
	public IClientDao getClientdao() {
		return clientdao;
	}

	public void setClientdao(IClientDao clientdao) {
		this.clientdao = clientdao;
	}

	
	
	@Override
	public void updateClient(Client client){
		
		clientdao.save(client);
	}

	
	@Override
	public void creerClient(Client client){
		
		clientdao.save(client);
	}
	
	

	@Override
	public List<Client> findByConseiller(Conseiller conseiller) {
		
		return clientdao.findByConseiller(conseiller);
	}

	public List<Client> getAllClient(){
		
		return clientdao.findAll();
		
	}
	
}
