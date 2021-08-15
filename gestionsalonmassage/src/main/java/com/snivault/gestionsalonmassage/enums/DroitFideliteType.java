package com.snivault.gestionsalonmassage.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Pour pouvoir savoir quelle classe construire Massage, ProduitFini ou
 * HuileMassage.
 * 
 * @author Nous
 *
 */
public enum DroitFideliteType {

	AUCUN_DROIT_EN_COURS("Aucun droit en cours", -1), CINQ_MASSAGES("5 massages : un massage gratuit ou une huile de massage gratuite", 5), TROIS_MASSAGES("3 massages : une huile végétale gratuite", 3);

	public static Map<DroitFideliteType, Integer> getMapNbVentes() {
		Map<DroitFideliteType, Integer> map = new HashMap<DroitFideliteType, Integer>();
		for (DroitFideliteType droit : DroitFideliteType.values()) {
			map.put(droit, droit.nbVentes);
		}
		return map;
	}

	private String libelle;

	private int nbVentes;

	DroitFideliteType(String libelle, int nbVentes) {
		this.libelle = libelle;
		this.nbVentes = nbVentes;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the nbVentes
	 */
	public int getNbVentes() {
		return nbVentes;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @param nbVentes the nbVentes to set
	 */
	public void setNbVentes(int nbVentes) {
		this.nbVentes = nbVentes;
	}

}
