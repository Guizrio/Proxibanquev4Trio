package com.proxibanquev4trio.dao;

import com.proxibanquev4trio.domaine.Client;

/**
 * Created by Guillaume on 06/10/2016.
 */
public class UnDao {

    public void getClientName() {

        System.out.println("------------------------------");
        Client client = new Client();
        client.setNom("Le nom du client");
        System.out.println(client.getNom());
        System.out.println("------------------------------");
    }
}
