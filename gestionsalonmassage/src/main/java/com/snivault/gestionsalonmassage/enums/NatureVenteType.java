package com.snivault.gestionsalonmassage.enums;

/**
 * Nature de la vente (prestation de service ou vente de marchandise).
 * 
 * @author Nous
 *
 */
public enum NatureVenteType {

	PRESTATION_SERVICE("PRESTATION_SERVICE", "ACTIVITE_PRINCIPALE"), VENTE_MARCHANDISE("VENTE_MARCHANDISE", "ACTIVITE_SECONDAIRE");

	private String libelleNature;

	private String typeActivite;

	NatureVenteType(String libelleNature, String typeActivite) {
		this.libelleNature = libelleNature;
		this.setTypeActivite(typeActivite);
	}

	/**
	 * @return the libelleNature
	 */
	public String getLibelleNature() {
		return libelleNature;
	}

	/**
	 * @return the typeActivite
	 */
	public String getTypeActivite() {
		return typeActivite;
	}

	/**
	 * @param libelleNature the libelleNature to set
	 */
	public void setLibelleNature(String libelleNature) {
		this.libelleNature = libelleNature;
	}

	/**
	 * @param typeActivite the typeActivite to set
	 */
	public void setTypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}
}
