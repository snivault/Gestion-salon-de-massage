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
@Table(name = "c_origine_contact")
public class OrigineContact {
	@Column(name = "c_libelle")
	private String libelle;

	@Id
	@GeneratedValue
	@Column(name = "c_origine_contact_id")
	private int origineContactId;

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the origineContactId
	 */
	public int getOrigineContactId() {
		return origineContactId;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @param origineContactId the origineContactId to set
	 */
	public void setOrigineContactId(int origineContactId) {
		this.origineContactId = origineContactId;
	}
}
