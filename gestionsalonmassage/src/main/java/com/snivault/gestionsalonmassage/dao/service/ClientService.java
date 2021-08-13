package com.snivault.gestionsalonmassage.dao.service;

import java.util.List;

import com.snivault.gestionsalonmassage.enums.DroitFideliteType;
import com.snivault.gestionsalonmassage.model.Client;
import com.snivault.gestionsalonmassage.model.Massage;
import com.snivault.gestionsalonmassage.model.Problematique;

/**
 * Service pour gérer les clients, proposer des massages, gérer ses droits de
 * fidélité.
 * 
 * @author Nous
 *
 */
public interface ClientService {
	void ajouterCarteFidelite(Client client);

	void ajouterProblematiques(Client client, List<Problematique> listProblematiques);

	DroitFideliteType consulterDroitsFidelites(int clientId);

	List<Massage> proposerMassagesAdaptes(int clientId);

	boolean verifierDernierCadeauRemis(int clientId);

}
