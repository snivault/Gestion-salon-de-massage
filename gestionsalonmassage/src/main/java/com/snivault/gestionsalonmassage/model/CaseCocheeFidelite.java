package com.snivault.gestionsalonmassage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Case cochée de la carte de fidélité propre à un client.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "v_case_cochee_fidelite")
public class CaseCocheeFidelite {
	@Id
	@GeneratedValue
	@Column(name = "v_case_cochee_fidelite_id")
	private Integer caseCocheeFideliteId;

	/**
	 * La case a été cochée suite soit à un rendez-vous de massage, soit à un achat
	 * de chèque cadeau.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_vente_cheque_cadeau_id")
	private ChequeCadeau chequeCadeau;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_client_id")
	private Client client;

	@Column(name = "c_date_cadeau")
	private Date dateCadeau;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_massage_id")
	private Massage massage;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_produit_fini_id")
	private ProduitFini produitFini;

	/**
	 * La case a été cochée suite soit à un rendez-vous de massage, soit à un achat
	 * de chèque cadeau.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_vente_massage_id")
	private RendezVousMassage rendezVousMassage;

	/**
	 * @return the caseCocheeFideliteId
	 */
	public Integer getCaseCocheeFideliteId() {
		return caseCocheeFideliteId;
	}

	/**
	 * @return the chequeCadeau
	 */
	public ChequeCadeau getChequeCadeau() {
		return chequeCadeau;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the dateCadeau
	 */
	public Date getDateCadeau() {
		return dateCadeau;
	}

	/**
	 * @return the massage
	 */
	public Massage getMassage() {
		return massage;
	}

	/**
	 * @return the produitFini
	 */
	public ProduitFini getProduitFini() {
		return produitFini;
	}

	/**
	 * @return the rendezVousMassage
	 */
	public RendezVousMassage getRendezVousMassage() {
		return rendezVousMassage;
	}

	/**
	 * @param caseCocheeFideliteId the caseCocheeFideliteId to set
	 */
	public void setCaseCocheeFideliteId(Integer caseCocheeId) {
		this.caseCocheeFideliteId = caseCocheeId;
	}

	/**
	 * @param chequeCadeau the chequeCadeau to set
	 */
	public void setChequeCadeau(ChequeCadeau chequeCadeau) {
		this.chequeCadeau = chequeCadeau;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @param dateCadeau the dateCadeau to set
	 */
	public void setDateCadeau(Date dateCadeau) {
		this.dateCadeau = dateCadeau;
	}

	/**
	 * @param massage the massage to set
	 */
	public void setMassage(Massage massage) {
		this.massage = massage;
	}

	/**
	 * @param produitFini the produitFini to set
	 */
	public void setProduitFini(ProduitFini produitFini) {
		this.produitFini = produitFini;
	}

	/**
	 * @param rendezVousMassage the rendezVousMassage to set
	 */
	public void setRendezVousMassage(RendezVousMassage rendezVousMassage) {
		this.rendezVousMassage = rendezVousMassage;
	}

}
