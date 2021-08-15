package com.snivault.gestionsalonmassage.dao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ListUtils;

import com.snivault.gestionsalonmassage.dao.CarteFideliteDao;
import com.snivault.gestionsalonmassage.dao.CaseCocheeFideliteDao;
import com.snivault.gestionsalonmassage.dao.ChequeCadeauDao;
import com.snivault.gestionsalonmassage.dao.ClientDao;
import com.snivault.gestionsalonmassage.dao.RendezVousMassageDao;
import com.snivault.gestionsalonmassage.model.CarteFidelite;
import com.snivault.gestionsalonmassage.model.CaseCocheeFidelite;
import com.snivault.gestionsalonmassage.model.ChequeCadeau;
import com.snivault.gestionsalonmassage.model.Client;
import com.snivault.gestionsalonmassage.model.Problematique;
import com.snivault.gestionsalonmassage.model.RendezVousMassage;

/**
 * Implémentation de {@link ClientService}.
 * 
 * @author Nous
 *
 */
@Component
public class ClientServiceImpl implements ClientService {

	public static final String ERR_CLIENT_NULL = "L'objet Client ne doit pas être null";

	@Autowired
	private CarteFideliteDao carteFideliteDao;

	@Autowired
	private CaseCocheeFideliteDao caseCocheeFideliteDao;

	@Autowired
	private ChequeCadeauDao chequeCadeauDao;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private RendezVousMassageDao rendezVousMassageDao;

	@Override
	public void ajouterCarteFidelite(Client client) throws IllegalArgumentException {
		if (null != client) {
			CarteFidelite carteFidelite = new CarteFidelite();
			client.setCarteFidelite(carteFidelite);
			clientDao.save(client);
			carteFideliteDao.save(carteFidelite);

		} else {
			throw new IllegalArgumentException(ERR_CLIENT_NULL);
		}
	}

	@Override
	public void ajouterProblematiques(Client client, List<Problematique> listProblematiques) {
		if (null != client && !ListUtils.isEmpty(listProblematiques)) {
			client.setListProblematiques(listProblematiques);
			clientDao.save(client);
		} else {
			throw new IllegalArgumentException(ERR_CLIENT_NULL);
		}
	}

	@Override
	public CaseCocheeFidelite getLastCaseCocheeFidelite(int clientId) {
		// Récupérer les dernières ventes (chèque cadeau et/ou rendez-vous massage)
		ChequeCadeau chequeCadeau = chequeCadeauDao.getLastChequeCadeau(clientId);
		RendezVousMassage rdvMassage = rendezVousMassageDao.getLastRendezVousMassage(clientId);

		// Récupérer les dates de ces objets
		Date dateDernierChequeCadeau = null;
		CaseCocheeFidelite caseCheque = null;
		CaseCocheeFidelite caseRdv = null;
		if (null != chequeCadeau) {
			dateDernierChequeCadeau = chequeCadeau.getDateVente();
			caseCheque = caseCocheeFideliteDao.getCaseByVenteChequeCadeauId(chequeCadeau.getVenteId());
		}
		Date dateDernierRdvMassage = null;
		if (null != rdvMassage) {
			dateDernierRdvMassage = rdvMassage.getDateVente();
			caseRdv = caseCocheeFideliteDao.getCaseByVenteRdvId(rdvMassage.getVenteId());
		}

		// Récupérer la case à cocher de la dernière vente
		if (null != dateDernierChequeCadeau && null != dateDernierRdvMassage) {
			// Date du dernier chèque cadeau est plus récente
			if (dateDernierChequeCadeau.compareTo(dateDernierRdvMassage) > 0) {
				return caseCheque;
			} else if (dateDernierChequeCadeau.compareTo(dateDernierRdvMassage) < 0) {
				// Date du dernier rendez-vous massage est plus récent
				return caseRdv;
			} else {
				// égal c'est le chèque cadeau qui est le dernier
				return caseCheque;

			}
		} else if (null != dateDernierChequeCadeau && null == dateDernierRdvMassage) {
			// chèque cadeau est le dernier
			return caseCheque;
		} else if (null != dateDernierRdvMassage && null == dateDernierChequeCadeau) {
			return caseRdv;
		} else {
			return null;
		}
	}

}
