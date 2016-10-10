package com.proxibanquev4trio.webservices;

import com.proxibanquev4trio.domaine.Virement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Guillaume on 09/10/2016.
 */
@Path("/virement")
public class VirementWebService {


//    @Inject
//    IVirementDao virementDao;



    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
//    @RolesAllowed(value = {"conseiller", "gerant"})
    public Virement afficherVirement() {

        Virement virement = new Virement();
        virement.setIdCrediteur(3L);
        virement.setIdDebiteur(42L);
        virement.setMontant(12345.6789);

        return virement;

    }


//    @POST
//    @Path("/post")
//    @Consumes(MediaType.APPLICATION_JSON)
////    @RolesAllowed(value = {"conseiller", "gerant"})
//    public Response createTrackInJSON(Virement virement) throws VirementNotFeasibleException {
//
//        try{
//
//            virementDao.save(virement);
//            return Response.status(201).entity(virement).build();
//
//        }catch (Exception e){
//            throw new VirementNotFeasibleException("Le virement n'a pu être effectué");
//        }
//
//    }
}
