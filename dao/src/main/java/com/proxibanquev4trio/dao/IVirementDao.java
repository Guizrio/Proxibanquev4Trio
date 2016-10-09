package com.proxibanquev4trio.dao;

import com.proxibanquev4trio.domaine.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Guillaume on 09/10/2016.
 */
public interface IVirementDao extends JpaRepository<Virement, Integer> {

}
