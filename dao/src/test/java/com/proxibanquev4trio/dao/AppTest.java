package com.proxibanquev4trio.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.dao.EmployeDao;
import com.objis.spring.domaine.Employe;
import com.proxibanquev4trio.domaine.Client;

import junit.framework.TestCase;

/**
 * Created by Stagiaire on 05/10/2016.
 */
public class AppTest extends TestCase {
	
	private Client client;
	private ClientDao dao;
	private ClassPathXmlApplicationContext appContext;
	
	
	
    @Test
    public void main() throws Exception {

    }
    
    @Test 
    public void testGetClientById(){
		
    	
    	
    	Long id = 1L;
    	List<Client> liste;
    	
    	liste=dao.getClientById(id);
    	
    	
    	
    	
    	
    }

}