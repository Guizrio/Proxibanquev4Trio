package com.proxibanquev4trio.services;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.proxibanquev4trio.dao.IClientDao;
import com.proxibanquev4trio.domaine.Client;

@Component
public class ClientService implements IClientService {
	
	@Inject
	IClientDao clientdao;
	
	/* (non-Javadoc)
	 * @see com.proxibanquev4trio.services.IClientService#updateClient(com.proxibanquev4trio.domaine.Client)
	 */
	@Override
	public void updateClient(Client client){
		
		clientdao.save(client);
	}

	/* (non-Javadoc)
	 * @see com.proxibanquev4trio.services.IClientService#creerClient(com.proxibanquev4trio.domaine.Client)
	 */
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
