package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query(value = "SELECT rdv1 FROM RendezVousMassage rdv1 WHERE rdv1.dateVente=(SELECT max(rdv2.dateVente) FROM RendezVousMassage rdv2 WHERE rdv2.client.clientId=:clientId)")
	RendezVousMassage getLastRendezVousMassage(@Param(value = "clientId") int clientId);

}
