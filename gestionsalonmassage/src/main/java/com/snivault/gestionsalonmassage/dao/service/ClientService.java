package com.snivault.gestionsalonmassage.dao.service;

import java.util.List;

import com.snivault.gestionsalonmassage.model.CaseCocheeFidelite;
import com.snivault.gestionsalonmassage.model.Client;
import com.snivault.gestionsalonmassage.model.Problematique;

/**
 * Service pour gérer les clients, proposer des massages, gérer ses droits de
 * fidélité.
 * 
 * @author Nous
 *
 */
public interface ClientService {
	/**
	 * Ajouter une carte de fidélité (elle est vide, c'est juste pour attribuer un
	 * n° en base).
	 * 
	 * @param client à modifier.
	 */
	void ajouterCarteFidelite(Client client);

	/**
	 * Ajouter une ou plusieurs problématiques à un client.
	 * 
	 * @param client             à modifier.
	 * @param listProblematiques à ajouter.
	 */
	void ajouterProblematiques(Client client, List<Problematique> listProblematiques);

	/**
	 * Renvoyer la dernière case cochée de la carte de fidélité.
	 * 
	 * @param clientId le client recherché.
	 * @return case cochée.
	 */
	CaseCocheeFidelite getLastCaseCocheeFidelite(int clientId);

}
