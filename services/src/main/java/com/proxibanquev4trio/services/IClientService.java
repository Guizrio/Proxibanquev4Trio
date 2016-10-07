package com.proxibanquev4trio.services;

import com.proxibanquev4trio.domaine.Client;

public interface IClientService {

	void updateClient(Client client);

	void creerClient(Client client);

}