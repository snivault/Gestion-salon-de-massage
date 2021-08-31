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
public class OrigineContact implements Cloneable {
	@Column(name = "c_libelle")
	private String libelle;

	@Id
	@GeneratedValue
	@Column(name = "c_origine_contact_id")
	private Integer origineContactId;

	@Override
	protected OrigineContact clone() throws CloneNotSupportedException {
		OrigineContact copie = (OrigineContact) super.clone();
		copie.libelle = libelle;
		copie.origineContactId = origineContactId;
		return copie;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the origineContactId
	 */
	public Integer getOrigineContactId() {
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
	public void setOrigineContactId(Integer origineContactId) {
		this.origineContactId = origineContactId;
	}
}
