package com.snivault.gestionsalonmassage.model;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

/**
 * Achats à apparaître dans le registre d'achat effectué auprès d'un
 * fournisseur.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_achat")
@NamedEntityGraph(name = "achat.listproduits", attributeNodes = @NamedAttributeNode("listProduits"))
public class Achat {
	@Id
	@GeneratedValue
	@Column(name = "m_achat_id")
	private Integer achatId;

	@Column(name = "m_date_achat")
	private Date dateAchat;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "m_achat_produit_fini", joinColumns = @JoinColumn(name = "m_achat_id"), inverseJoinColumns = @JoinColumn(name = "m_produit_id"))
	private List<ProduitFini> listProduits;

	@Column(name = "m_montant")
	private float montant;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "va_moyen_paiement_id")
	private MoyenPaiement moyenPaiement;

	@Column(name = "m_type_achat")
	private String typeAchat;

	/**
	 * @return the achatId
	 */
	public Integer getAchatId() {
		return achatId;
	}

	/**
	 * @return the dateAchat
	 */
	public Date getDateAchat() {
		return dateAchat;
	}

	/**
	 * @return the listProduits
	 */
	public List<ProduitFini> getListProduits() {
		return listProduits;
	}

	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * @return the moyenPaiement
	 */
	public MoyenPaiement getMoyenPaiement() {
		return moyenPaiement;
	}

	/**
	 * @return the typeAchat
	 */
	public String getTypeAchat() {
		return typeAchat;
	}

	/**
	 * @param achatId the achatId to set
	 */
	public void setAchatId(Integer achatId) {
		this.achatId = achatId;
	}

	/**
	 * @param dateAchat the dateAchat to set
	 */
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	/**
	 * @param listProduits the listProduits to set
	 */
	public void setListProduits(List<ProduitFini> listProduits) {
		this.listProduits = listProduits;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}

	/**
	 * @param moyenPaiement the moyenPaiement to set
	 */
	public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}

	/**
	 * @param typeAchat the typeAchat to set
	 */
	public void setTypeAchat(String typeAchat) {
		this.typeAchat = typeAchat;
	}

}
