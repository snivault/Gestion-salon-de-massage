package com.snivault.gestionsalonmassage.dao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snivault.gestionsalonmassage.dao.ClientDao;
import com.snivault.gestionsalonmassage.enums.DroitFideliteType;
import com.snivault.gestionsalonmassage.model.Client;
import com.snivault.gestionsalonmassage.model.Massage;
import com.snivault.gestionsalonmassage.model.Problematique;

/**
 * Implémentation de {@link ClientService}.
 * 
 * @author Nous
 *
 */
@Component
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;

	@Override
	public void ajouterCarteFidelite(Client client) {

	}

	@Override
	public void ajouterProblematiques(Client client, List<Problematique> listProblematiques) {
		// TODO Auto-generated method stub

	}

	@Override
	public DroitFideliteType consulterDroitsFidelites(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the clientDao
	 */
	public ClientDao getClientDao() {
		return clientDao;
	}

	@Override
	public List<Massage> proposerMassagesAdaptes(int clientId) {
		List<Massage> listMassages = new ArrayList<Massage>();
		// Récupérer le client
		Client client = clientDao.getById(clientId);
		List<Problematique> listProblematiques = client.getListProblematiques();
		if (!listProblematiques.isEmpty()) {
			for (Problematique problematique : listProblematiques) {
				System.out.println(problematique.getLibelle());
			}
		}

		// TODO : compléter cette méthode
		return listMassages;
	}

	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public boolean verifierDernierCadeauRemis(int clientId) {
		// TODO Auto-generated method stub
		return false;
	}

}
