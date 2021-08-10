package com.snivault.gestionsalonmassage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Produit fini (peut représenter une huile, une serviette,... à acheter ou à
 * vendre).
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_produit_fini")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "m_produit_type")
public class ProduitFini extends ProduitMixteAbstract {
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "m_fournisseur")
	private List<Fournisseur> listFournisseurs;

	@Column(name = "m_reference")
	private String reference;

	@Column(name = "m_tarif")
	private String tarif;

	/**
	 * @return the listFournisseurs
	 */
	public List<Fournisseur> getListFournisseurs() {
		return listFournisseurs;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @return the tarif
	 */
	public String getTarif() {
		return tarif;
	}

	@Override
	public void methodeA() {
		// TODO mafactory à compléter
		System.out.println("A implémenter pour le produit fini");
	}

	/**
	 * @param listFournisseurs the listFournisseurs to set
	 */
	public void setListFournisseurs(List<Fournisseur> listFournisseurs) {
		this.listFournisseurs = listFournisseurs;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @param tarif the tarif to set
	 */
	public void setTarif(String tarif) {
		this.tarif = tarif;
	}

}