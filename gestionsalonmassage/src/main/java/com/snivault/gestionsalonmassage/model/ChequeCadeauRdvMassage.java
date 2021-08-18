package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Le ou les rdv effectués par chèque cadeau.
 * 
 * @author Nous
 *
 */
@Table(name = "v_cheque_cadeau_rdv_massage")
public class ChequeCadeauRdvMassage {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_cheque_cadeau_id")
	private ChequeCadeau chequeCadeau;

	@Id
	@GeneratedValue
	@Column(name = "v_cheque_cadeau_rdv_massage_id")
	private Integer chequeCadeauRdvMassageId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_rendez_vous_massage_id")
	private RendezVousMassage rendezVousMassage;

	/**
	 * @return the chequeCadeau
	 */
	public ChequeCadeau getChequeCadeau() {
		return chequeCadeau;
	}

	/**
	 * @return the chequeCadeauRdvMassageId
	 */
	public Integer getChequeCadeauRdvMassageId() {
		return chequeCadeauRdvMassageId;
	}

	/**
	 * @return the rendezVousMassage
	 */
	public RendezVousMassage getRendezVousMassage() {
		return rendezVousMassage;
	}

	/**
	 * @param chequeCadeau the chequeCadeau to set
	 */
	public void setChequeCadeau(ChequeCadeau chequeCadeau) {
		this.chequeCadeau = chequeCadeau;
	}

	/**
	 * @param chequeCadeauRdvMassageId the chequeCadeauRdvMassageId to set
	 */
	public void setChequeCadeauRdvMassageId(Integer chequeCadeauRdvMassageId) {
		this.chequeCadeauRdvMassageId = chequeCadeauRdvMassageId;
	}

	/**
	 * @param rendezVousMassage the rendezVousMassage to set
	 */
	public void setRendezVousMassage(RendezVousMassage rendezVousMassage) {
		this.rendezVousMassage = rendezVousMassage;
	}
}
