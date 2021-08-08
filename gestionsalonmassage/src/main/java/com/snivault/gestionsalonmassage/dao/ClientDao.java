package com.snivault.gestionsalonmassage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snivault.gestionsalonmassage.model.Client;

/**
 * Interface d'accès à la table représentant les clients du salon de massage.
 * 
 * @author Nous
 *
 */
public interface ClientDao extends JpaRepository<Client, Integer> {
	// SELECT * FROM c_client WHERE nom LIKE '%nomFamille%'
	List<Client> findByNomFamille(String nomFamille); // exact ou like

	// SELECT * FROM c_client WHERE nom LIKE '%nom%' AND prenom LIKE '%prenom%'
	List<Client> findByNomPrenom(String nom, String prenom);

}
