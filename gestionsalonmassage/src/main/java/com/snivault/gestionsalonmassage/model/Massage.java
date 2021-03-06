package com.snivault.gestionsalonmassage.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;

/**
 * Les massages proposés par le salon et pourquoi pas d'autres pour enregistrer
 * aussi les bienfaits.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_massage")
@NamedEntityGraph(name = "massage.listbienfaits", attributeNodes = @NamedAttributeNode(value = "listBienfaits", subgraph = "bienfait.listproblematiques"), subgraphs = {
		@NamedSubgraph(name = "bienfait.listproblematiques", attributeNodes = @NamedAttributeNode(value = "listProblematiques")) })
public class Massage extends ProduitMixteAbstract {
	@Column(name = "m_duree_prevue_m")
	private Date dureePrevue;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_produit_fini_id")
	private HuileMassage huileMassage;

	@Column(name = "m_libelle")
	private String libelle;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "m_massage_bienfait", joinColumns = @JoinColumn(name = "m_produit_id"), inverseJoinColumns = @JoinColumn(name = "m_bienfait_id"))
	private List<Bienfait> listBienfaits;

	@Column(name = "m_tarif_prevu")
	private Float tarifPrevu;

	/**
	 * @return the dureePrevue
	 */
	public Date getDureePrevue() {
		return dureePrevue;
	}

	/**
	 * @return the huileMassage
	 */
	public HuileMassage getHuileMassage() {
		return huileMassage;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the listBienfaits
	 */
	public List<Bienfait> getListBienfaits() {
		return listBienfaits;
	}

	/**
	 * @return the tarifPrevu
	 */
	public Float getTarifPrevu() {
		return tarifPrevu;
	}

	@Override
	public void methodeA() {
		// TODO mafactory à compléter
		System.out.println("à compléter");

	}

	/**
	 * @param dureePrevue the dureePrevue to set
	 */
	public void setDureePrevue(Date dureePrevue) {
		this.dureePrevue = dureePrevue;
	}

	/**
	 * @param huileMassage the huileMassage to set
	 */
	public void setHuileMassage(HuileMassage huileMassage) {
		this.huileMassage = huileMassage;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @param listBienfaits the listBienfaits to set
	 */
	public void setListBienfaits(List<Bienfait> listBienfaits) {
		this.listBienfaits = listBienfaits;
	}

	/**
	 * @param tarifPrevu the tarifPrevu to set
	 */
	public void setTarifPrevu(Float tarifPrevu) {
		this.tarifPrevu = tarifPrevu;
	}
}
