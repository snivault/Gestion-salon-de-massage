package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "v_cheque_cadeau_rdv_massage")
public class ChequeCadeauRdvMassage {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_cheque_cadeau_id")
	private ChequeCadeau chequeCadeau;

	@Id
	@GeneratedValue
	@Column(name = "v_cheque_cadeau_rdv_massage_id")
	private int chequeRdvId;

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
	 * @return the chequeRdvId
	 */
	public int getChequeRdvId() {
		return chequeRdvId;
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
	 * @param chequeRdvId the chequeRdvId to set
	 */
	public void setChequeRdvId(int chequeRdvId) {
		this.chequeRdvId = chequeRdvId;
	}

	/**
	 * @param rendezVousMassage the rendezVousMassage to set
	 */
	public void setRendezVousMassage(RendezVousMassage rendezVousMassage) {
		this.rendezVousMassage = rendezVousMassage;
	}
}
