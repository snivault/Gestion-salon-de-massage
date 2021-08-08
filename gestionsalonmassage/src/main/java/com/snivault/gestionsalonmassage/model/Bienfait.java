package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment la personne a connu le salon de massage.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_bienfait")
public class Bienfait {
	@Id
	@GeneratedValue
	@Column(name = "m_bienfait_id")
	private int bienfaitId;

	@Column(name = "m_libelle")
	private String libelle;

	/**
	 * @return the bienfaitId
	 */
	public int getBienfaitId() {
		return bienfaitId;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param bienfaitId the bienfaitId to set
	 */
	public void setBienfaitId(int bienfaitId) {
		this.bienfaitId = bienfaitId;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
