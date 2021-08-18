package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Exemple de problématique (arthrose, manque de sommeil, surpoids...).
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "c_problematique")
public class Problematique {
	@Column(name = "c_libelle")
	private String libelle;

	@Id
	@GeneratedValue
	@Column(name = "c_problematique_id")
	private Integer problematiqueId;

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the problematiqueId
	 */
	public Integer getProblematiqueId() {
		return problematiqueId;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @param problematiqueId the problematiqueId to set
	 */
	public void setProblematiqueId(Integer problematiqueId) {
		this.problematiqueId = problematiqueId;
	}
}
