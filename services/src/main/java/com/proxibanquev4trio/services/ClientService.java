package com.proxibanquev4trio.services;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.proxibanquev4trio.dao.IClientDao;
import com.proxibanquev4trio.domaine.Client;

@Component
public class ClientService implements IClientService {
	
	@Inject
	IClientDao clientdao;
	
	
	@Override
	public void updateClient(Client client){
		
		clientdao.save(client);
	}

	
	@Override
	public void creerClient(Client client){
		
		clientdao.save(client);
	}
	
	public IClientDao getClientdao() {
		return clientdao;
	}

	public void setClientdao(IClientDao clientdao) {
		this.clientdao = clientdao;
	}

}
