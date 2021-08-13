package com.snivault.gestionsalonmassage.dao.service;

import java.util.Map;
import java.util.function.Predicate;

import com.snivault.gestionsalonmassage.model.Achat;
import com.snivault.gestionsalonmassage.model.ChequeCadeau;
import com.snivault.gestionsalonmassage.model.RendezVousMassage;
import com.snivault.gestionsalonmassage.model.Vente;

/**
 * Implémentation de {@link ComptabiliteService}.
 * 
 * @author Nous
 *
 */
public class ComptabiliteServiceImpl implements ComptabiliteService {

	@Override
	public Predicate<Achat> consulterListeAchats(Map<String, String> colonnesFiltrees) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Predicate<Vente> consulterListeVentes(Map<String, String> colonnesFiltrees) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Predicate<RendezVousMassage> consulterRendezVousMassages(Map<String, String> colonnesFiltrees) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Predicate<ChequeCadeau> consulterVentesChequesCadeaux(Map<String, String> colonnesFiltrees) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Predicate<ChequeCadeau> consulterVentesProduitsFinis(Map<String, String> colonnesFiltrees) {
		// TODO Auto-generated method stub
		return null;
	}

}
