package com.snivault.gestionsalonmassage.runner;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.snivault.gestionsalonmassage.controllers.ClientController;
import com.snivault.gestionsalonmassage.controllers.VenteController;
import com.snivault.gestionsalonmassage.dao.ClientDao;
import com.snivault.gestionsalonmassage.model.Client;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private ClientController clientController;
	@Autowired
	private ClientDao clientDao;

	@Autowired
	private VenteController venteController;

	@Override
	public void run(String... args) throws Exception {
		// PETITS TESTS POUR LES CLIENTS
		Client bruno = clientDao.getById(1);
		// Tester les massages adaptés
		Stream<Entry<String, Integer>> stream = clientController.proposerMassagesAdaptes(bruno);
		stream.forEach(e -> System.out.println(e.getKey() + e.getValue()));

		// Consulter droits fidélité
		System.out.println(clientController.consulterDroitsFidelites(bruno).getLibelle());

		// Tester le dernier cadeau remis
		System.out.println(clientController.verifierDernierCadeauRemis(bruno));

		// PETITS TESTS POUR LES VENTES

		// TODO les chèques en cours ne prennent en compte que ceux qui sont sont en
		// cours et qui ont déja eu des rdv, pas ceux qui n'ont pas encore été pris du
		// tout
		// Chèques en cours
		List<Object[]> listChqEnCours = venteController.consulterChequesCadeauxEnCours();
		StringBuilder strBuilder = new StringBuilder();
		listChqEnCours.forEach(object -> {
			strBuilder.append(" ").append(object[0]);
			strBuilder.append(" ").append("Nom client inconnu").append((String) object[1]);
			strBuilder.append(" ").append("id client connu").append(object[3]);
			strBuilder.append(" ").append(object[8]);
			strBuilder.append(" ").append(object[9]).append(System.getProperty("line.separator"));
		});
		System.out.println(strBuilder.append(System.getProperty("line.separator")).toString());

		// Chèques en terminés
		List<Object[]> listChqTermines = venteController.consulterChequesCadeauxTermines();
		StringBuilder strBuilder2 = new StringBuilder();
		listChqTermines.forEach(object -> {
			strBuilder2.append(" ").append(object[0]);
			strBuilder2.append(" ").append("Nom client inconnu").append((String) object[1]);
			strBuilder2.append(" ").append("id client connu").append(object[3]);
			strBuilder2.append(" ").append(object[8]);
			strBuilder2.append(" ").append(object[9]).append(System.getProperty("line.separator"));
		});
		System.out.println(strBuilder2.toString());

	}
}
