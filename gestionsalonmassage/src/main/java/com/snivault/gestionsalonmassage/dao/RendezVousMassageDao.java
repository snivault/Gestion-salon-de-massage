package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snivault.gestionsalonmassage.model.RendezVousMassage;

/**
 * Interface d'accès à la table représentant les clients du salon de massage.
 * 
 * @author Nous
 *
 */
@Repository
public interface RendezVousMassageDao extends JpaRepository<RendezVousMassage, Integer> {

	@Override
	@EntityGraph(value = "rendezvousmassage.listproblematiques")
	RendezVousMassage getById(Integer rendezVousMassageId);

}
