package com.proxibanquev4trio.services;

import com.proxibanquev4trio.dao.IVirementDao;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.domaine.Virement;
import com.proxibanquev4trio.logging.Loggable;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

/**
 * Created by Guillaume on 09/10/2016.
 */
@Component
public class VirementService implements IVirementService {
	
	
	@Inject
	IVirementDao virementDao;
	
	
	public List<Virement> getAllVirementBetween(Date date1, Date date2){
		
		return virementDao.findAllTimeStampBetweenOrderByTimeStampAsc(date1, date2);
		
	}
	
	public List<Virement> getAllVirement(){
		
		return virementDao.findAll();
		
	}



    @Override
    @Loggable
    public void effectuerVirement(Compte debiteur, Compte crediteur, double montant) {

    }

    @Override
    @Loggable
    public void effectuerVirement(Virement virement) {
//        try {
//
//            Client client = Client.create();
//
//            WebResource webResource = client
//                    .resource("http://localhost:8080/proxibanquev4trio-webservices/virement/post");
//
//
//            //Transform virement into json parsed string
//            ObjectMapper mapper = new ObjectMapper();
//            String input = mapper.convertValue(virement, String.class);
//
//            ClientResponse response = webResource.type("application/json")
//                    .post(ClientResponse.class, input);
//
//            if (response.getStatus() != 201) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + response.getStatus());
//            }
//
//            System.out.println("Output from Server .... \n");
//            Virement output = response.readEntity(Virement.class);
//            System.out.println(output);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
    }


}
