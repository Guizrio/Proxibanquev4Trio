package com.proxibanquev4trio.services;

import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.domaine.Virement;

/**
 * Created by Guillaume on 09/10/2016.
 */
public interface IVirementService {


    void effectuerVirement(Compte debiteur, Compte crediteur, double montant);

    void effectuerVirement(Virement virement);

}
