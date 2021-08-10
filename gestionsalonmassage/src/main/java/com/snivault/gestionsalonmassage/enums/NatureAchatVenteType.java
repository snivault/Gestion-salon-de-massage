package com.snivault.gestionsalonmassage.enums;

/**
 * Nature de la vente ou de l'achat (prestation de service ou vente de
 * marchandise).
 * 
 * @author Nous
 *
 */
public enum NatureAchatVenteType {

	PRESTATION_SERVICE("PRESTATION_SERVICE"), VENTE_MARCHANDISE("VENTE_MARCHANDISE");

	private String libelleNature;

	NatureAchatVenteType(String libelleNature) {
		this.libelleNature = libelleNature;
	}

	/**
	 * @return the libelleNature
	 */
	public String getLibelleNature() {
		return libelleNature;
	}

	/**
	 * @param libelleNature the libelleNature to set
	 */
	public void setLibelleNature(String libelleNature) {
		this.libelleNature = libelleNature;
	}
}
