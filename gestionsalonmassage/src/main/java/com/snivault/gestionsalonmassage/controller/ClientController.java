package com.snivault.gestionsalonmassage.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snivault.gestionsalonmassage.dao.ClientDao;
import com.snivault.gestionsalonmassage.dao.MassageDao;
import com.snivault.gestionsalonmassage.dao.ViewMassageAdapteDao;
import com.snivault.gestionsalonmassage.dao.service.ClientService;
import com.snivault.gestionsalonmassage.dao.service.ClientServiceImpl;
import com.snivault.gestionsalonmassage.enums.DroitFideliteType;
import com.snivault.gestionsalonmassage.model.CaseCocheeFidelite;
import com.snivault.gestionsalonmassage.model.Client;

/**
 * Controleur pour les clients. C'est celui-ci qui fait le lien avec les pages
 * HTML. CrossOrigin indique quel domaine et port on accepte puisque le backend
 * tourne sur un port (ex : 8081) différent de celui du front (ex : 3000).
 */
@RestController
@RequestMapping("api/v1/client")
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private ClientService clientService;

	@Autowired
	private MassageDao massageDao;

	@PostMapping
	public ResponseEntity<Client> ajouterClient(@PathVariable Client client) throws URISyntaxException {
		Client sauvClient = clientDao.save(client);
		return ResponseEntity.created(new URI("/Clients/".concat(String.valueOf(sauvClient.getClientId())))).body(sauvClient);
	}

	/**
	 * Consulter les droits de fidélité d'un client. La fonction retourne une chaîne
	 * de caractères. Si le client a un cadeau en cours non remis, la fonction
	 * retourne ce droit, sinon la fonction retourne qu'il n'y a aucun droit.
	 * 
	 * @param clientId à consulter
	 * @return la chaîne de caractères concernant les droits de fidélité.
	 */
	public DroitFideliteType consulterDroitsFidelites(Client client) {
		List<CaseCocheeFidelite> listCases = client.getListCaseCochees();
		if (null != client && !listCases.isEmpty()) {
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

	@GetMapping
	public List<Client> getClients() {
		return clientDao.findAll();
	}

	@PutMapping("/{clientId}")
	public ResponseEntity<Client> modifierClient(@PathVariable Integer clientId, @RequestBody Client client) throws CloneNotSupportedException {
		Client clientAModifier = clientDao.findById(clientId).orElseThrow(RuntimeException::new);
		System.out.println(client.getTelephone());
		clientAModifier = client.clone();
		clientDao.save(clientAModifier);
		return ResponseEntity.ok(clientAModifier);
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
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Client> supprimerCient(@PathVariable Integer clientId) {
		clientDao.deleteById(clientId);
		return ResponseEntity.ok().build();
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
