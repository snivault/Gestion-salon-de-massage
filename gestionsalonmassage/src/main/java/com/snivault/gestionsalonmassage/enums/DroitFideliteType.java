package com.snivault.gestionsalonmassage.enums;

/**
 * Pour pouvoir savoir quelle classe construire Massage, ProduitFini ou
 * HuileMassage.
 * 
 * @author Nous
 *
 */
public enum DroitFideliteType {

	CINQ_MASSAGES("5 massages : un massage gratuit ou une huile de massage gratuite"),
	TROIS_MASSAGES("3 massages : une huile végétale gratuite");

	private String libelle;

	DroitFideliteType(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
