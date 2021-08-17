package com.snivault.gestionsalonmassage.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.snivault.gestionsalonmassage.dao.CarteFideliteDao;
import com.snivault.gestionsalonmassage.dao.ClientDao;
import com.snivault.gestionsalonmassage.dao.MassageDao;
import com.snivault.gestionsalonmassage.dao.ViewMassageAdapteDao;
import com.snivault.gestionsalonmassage.dao.service.ClientService;
import com.snivault.gestionsalonmassage.dao.service.ClientServiceImpl;
import com.snivault.gestionsalonmassage.enums.DroitFideliteType;
import com.snivault.gestionsalonmassage.model.CarteFidelite;
import com.snivault.gestionsalonmassage.model.CaseCocheeFidelite;
import com.snivault.gestionsalonmassage.model.Client;

@Controller
public class ClientController {

	@Autowired
	private CarteFideliteDao carteFideliteDao;

	@Autowired
	ClientDao clientDao;

	@Autowired
	ClientService clientService;
	@Autowired
	private MassageDao massageDao;

	/**
	 * Consulter les droits de fidélité d'un client. La fonction retourne une chaîne
	 * de caractères. Si le client a un cadeau en cours non remis, la fonction
	 * retourne ce droit, sinon la fonction retourne qu'il n'y a aucun droit.
	 * 
	 * @param clientId à consulter
	 * @return la chaîne de caractères concernant les droits de fidélité.
	 */
	public DroitFideliteType consulterDroitsFidelites(Client client) {
		CarteFidelite carteFidelite = carteFideliteDao.getById(client.getCarteFidelite().getCarteFideliteId());
		if (null != client && null != carteFidelite) {
			List<CaseCocheeFidelite> listCases = carteFidelite.getListCaseCochees();
			for (DroitFideliteType droit : DroitFideliteType.getMapNbVentes().keySet()) {
				if (listCases.size() == droit.getNbVentes()) {
					return droit;
				}
			}
			// Aucun droit puisqu'on la taille de la liste ne correspond pas à un droit
			return DroitFideliteType.AUCUN_DROIT_EN_COURS;
		} else {
			return null;
		}
	}

	/**
	 * Proposer les massages les plus adaptés triés par ordre du plus adapté au
	 * moins adapté. Le dernier a quand même au moins une problématique à laquelle
	 * il peut répondre. Retourne une map avec les massages puis le nombre de
	 * problématiques que le massage peut aider.
	 * 
	 * @param client
	 * @return
	 */
	public Stream<Map.Entry<String, Integer>> proposerMassagesAdaptes(Client client) {

		Map<String, Integer> mapMassages = new HashMap<>();
		List<ViewMassageAdapteDao> listMassagesAdaptes = massageDao.getMassageAdapte(client.getClientId());
		if (!listMassagesAdaptes.isEmpty()) {
			listMassagesAdaptes.forEach(massage -> mapMassages.put(massage.getM_LIBELLE(), massage.getNB_PROBLEMATIQUES()));
		}

		return mapMassages.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
	}

	/**
	 * Vrai si le dernier cadeau a été remis. Si aucun droit de cadeau alors
	 * retourne VRAI.
	 * 
	 * @param client
	 * @return vrai si le dernier cadeau a été remis
	 */
	public boolean verifierDernierCadeauRemis(Client client) {
		if (null != client) {
			CaseCocheeFidelite caseCocheeFidelite = clientService.getLastCaseCocheeFidelite(client.getClientId());
			return null != caseCocheeFidelite.getMassage() || null != caseCocheeFidelite.getProduitFini();
		} else {
			throw new IllegalArgumentException(ClientServiceImpl.ERR_CLIENT_NULL);
		}
	}
}
