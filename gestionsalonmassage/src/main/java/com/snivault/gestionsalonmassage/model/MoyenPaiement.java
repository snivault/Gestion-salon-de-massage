package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Moyen de paiement (ex : carte bancaire) pour les achats et les ventes.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "va_moyen_paiement")
public class MoyenPaiement {
	@Column(name = "va_libelle")
	private String libelle;

	@Id
	@GeneratedValue
	@Column(name = "va_moyen_paiement_id")
	private int moyenPaiementId;

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the moyenPaiementId
	 */
	public int getMoyenPaiementId() {
		return moyenPaiementId;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @param moyenPaiementId the moyenPaiementId to set
	 */
	public void setMoyenPaiementId(int moyenPaiementId) {
		this.moyenPaiementId = moyenPaiementId;
	}
}
