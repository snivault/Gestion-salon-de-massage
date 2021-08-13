package com.snivault.gestionsalonmassage.dao.service;

import java.util.Map;
import java.util.function.Predicate;

import com.snivault.gestionsalonmassage.model.Achat;
import com.snivault.gestionsalonmassage.model.ChequeCadeau;
import com.snivault.gestionsalonmassage.model.RendezVousMassage;
import com.snivault.gestionsalonmassage.model.Vente;

/**
 * Interface permettant de gérer les chiffres des ventes et des achats.
 * 
 * @author Nous
 *
 */
public interface ComptabiliteService {
	/**
	 * Consulter la liste des achats avec ou sans filtres.
	 * 
	 * @param colonnesFiltrees la clé est le nom de la colonne à filtrer, la valeur
	 *                         est la valeur de la colonne à filtrer.
	 * @return liste filtrées.
	 */
	Predicate<Achat> consulterListeAchats(Map<String, String> colonnesFiltrees);

	/**
	 * Consulter la liste des ventes avec ou sans filtres (Toutes les ventes
	 * massages, chèques cadeau et produits finis).
	 * 
	 * @param colonnesFiltrees la clé est le nom de la colonne à filtrer, la valeur
	 *                         est la valeur de la colonne à filtrer.
	 * @return liste filtrées.
	 */
	Predicate<Vente> consulterListeVentes(Map<String, String> colonnesFiltrees);

	/**
	 * Consulter la liste des rendez-vous de massages avec ou sans filtres.
	 * 
	 * @param colonnesFiltrees la clé est le nom de la colonne à filtrer, la valeur
	 *                         est la valeur de la colonne à filtrer.
	 * @return liste filtrées.
	 */
	Predicate<RendezVousMassage> consulterRendezVousMassages(Map<String, String> colonnesFiltrees);

	/**
	 * Consulter la liste des ventes de chèques cadeau avec ou sans filtres.
	 * 
	 * @param colonnesFiltrees la clé est le nom de la colonne à filtrer, la valeur
	 *                         est la valeur de la colonne à filtrer.
	 * @return liste filtrées.
	 */
	Predicate<ChequeCadeau> consulterVentesChequesCadeaux(Map<String, String> colonnesFiltrees);

	/**
	 * Consulter la liste des ventes de produits finis avec ou sans filtres.
	 * 
	 * @param colonnesFiltrees la clé est le nom de la colonne à filtrer, la valeur
	 *                         est la valeur de la colonne à filtrer.
	 * @return liste filtrées.
	 */
	Predicate<ChequeCadeau> consulterVentesProduitsFinis(Map<String, String> colonnesFiltrees);

}
