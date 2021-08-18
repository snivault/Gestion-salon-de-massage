package com.snivault.gestionsalonmassage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.snivault.gestionsalonmassage.enums.NatureVenteType;

/**
 * Vente de massage ou de produit comme une huile de massage.
 * 
 * @author Nous
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vente {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_client_id")
	private Client client;

	@Column(name = "v_date_vente")
	private Date dateVente;

	@Column(name = "v_montant_encaisse")
	private Float montantEncaisse;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "va_moyen_paiement_id")
	private MoyenPaiement moyenPaiement;

	/**
	 * Prestation de service ou vente de marchandise.
	 */
	@Column(name = "v_nature")
	private NatureVenteType nature;

	@Id
	@GeneratedValue
	@Column(name = "v_vente_id")
	private Integer venteId;

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the dateVente
	 */
	public Date getDateVente() {
		return dateVente;
	}

	/**
	 * @return the montantEncaisse
	 */
	public Float getMontantEncaisse() {
		return montantEncaisse;
	}

	/**
	 * @return the moyenPaiement
	 */
	public MoyenPaiement getMoyenPaiement() {
		return moyenPaiement;
	}

	/**
	 * @return the nature
	 */
	public NatureVenteType getNature() {
		return nature;
	}

	/**
	 * @return the venteId
	 */
	public Integer getVenteId() {
		return venteId;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @param dateVente the dateVente to set
	 */
	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	/**
	 * @param montantEncaisse the montantEncaisse to set
	 */
	public void setMontantEncaisse(Float montantEncaisse) {
		this.montantEncaisse = montantEncaisse;
	}

	/**
	 * @param moyenPaiement the moyenPaiement to set
	 */
	public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}

	/**
	 * @param nature the nature to set
	 */
	public void setNature(NatureVenteType nature) {
		this.nature = nature;
	}

	/**
	 * @param venteId the venteId to set
	 */
	public void setVenteId(Integer venteId) {
		this.venteId = venteId;
	}
}
