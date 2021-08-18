package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * TABLE_PER_CLASS signifie qu'en base, toutes les entités filles à cette classe
 * abstraite, ont une table et elles répètent les champs de cette superclasse.
 * 
 * @author Nous
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ProduitMixteAbstract {

	/** Libellé du produit ou du massage. */
	private String libelle;

	/**
	 * L'identifiant correspondant à celui de la table de la BDD correspondante
	 * (soit Massage, ProduitFini,...)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "m_produit_id")
	private Integer produitMixteId;

	/**
	 * @return the produitMixteId
	 */
	public Integer getProduitMixteId() {
		return produitMixteId;
	}

	// TODO mafactory à compléter
	public abstract void methodeA();

	/**
	 * @param produitMixteId the produitMixteId to set
	 */
	public void setProduitMixteId(Integer produitMixteId) {
		this.produitMixteId = produitMixteId;
	}

}
