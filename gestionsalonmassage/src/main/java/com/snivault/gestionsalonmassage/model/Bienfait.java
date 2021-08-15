package com.snivault.gestionsalonmassage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

/**
 * Binefait d'un massage (ex : relaxant, harmonise l'énergie).
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_bienfait")
@NamedEntityGraph(name = "bienfait.listproblematiques", attributeNodes = @NamedAttributeNode("listProblematiques"))
public class Bienfait {
	@Id
	@GeneratedValue
	@Column(name = "m_bienfait_id")
	private int bienfaitId;

	@Column(name = "m_libelle")
	private String libelle;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "m_bienfait_problematique", joinColumns = @JoinColumn(name = "m_bienfait_id"), inverseJoinColumns = @JoinColumn(name = "c_problematique_id"))
	private List<Problematique> listProblematiques;

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
	 * @return the listProblematiques
	 */
	public List<Problematique> getListProblematiques() {
		return listProblematiques;
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

	/**
	 * @param listProblematiques the listProblematiques to set
	 */
	public void setListProblematiques(List<Problematique> listProblematiques) {
		this.listProblematiques = listProblematiques;
	}

}
