package com.snivault.gestionsalonmassage.dao.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.snivault.gestionsalonmassage.dao.ViewRegistreAchatsDepensesAutresDao;
import com.snivault.gestionsalonmassage.dao.ViewVentesChqRdvProduitDao;

/**
 * Interface permettant de gérer les chiffres des ventes et des achats.
 * 
 * @author Nous
 *
 */
public interface ComptabiliteService {
	/**
	 * Consulter la liste des ventes avec ou sans filtres (Toutes les ventes
	 * massages, chèques cadeau et produits finis).
	 * 
	 * @return liste filtrées.
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM v_ventes_chq_rdv_produit")
	List<ViewVentesChqRdvProduitDao> consulterListeVentes();

	/**
	 * Consulter la liste des achats (correspondant au registres des achats et
	 * dépenses autres).
	 * 
	 * @return la liste.
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM m_registre_achats_depenses_autres")
	public List<ViewRegistreAchatsDepensesAutresDao> consulterRegistreAchatsDepensesAutres();

}
