package com.snivault.gestionsalonmassage.enums;

/**
 * Pour pouvoir savoir quelle classe construire Massage, ProduitFini ou
 * HuileMassage.
 * 
 * @author Nous
 *
 */
public enum CategorieProduitType {

	AUTRE("AUTRE"), HUILE_MASSAGE("HUILE_MASSAGE"), MASSAGE("MASSAGE");

	private String libelleCategorie;

	CategorieProduitType(String libelleCategorie) {
		this.setLibelleCategorie(libelleCategorie);
	}

	/**
	 * @return the libelleCategorie
	 */
	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	/**
	 * @param libelleCategorie the libelleCategorie to set
	 */
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}
}
