package com.proxibanquev4trio.services;

import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.domaine.Virement;
import com.proxibanquev4trio.logging.Loggable;
import org.springframework.stereotype.Component;

/**
 * Created by Guillaume on 09/10/2016.
 */
@Component
public class VirementService implements IVirementService {


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
