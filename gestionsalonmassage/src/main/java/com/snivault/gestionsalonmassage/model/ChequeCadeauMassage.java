package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Table d'association pour les massages prévu pour un chèque cadeau. Si pas de
 * ligne pour le chèque cadeau, alors on considère que c'est un massage au
 * choix.
 * 
 * @author Nous
 *
 */
@Table(name = "v_cheque_cadeau_massage")
public class ChequeCadeauMassage {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_cheque_cadeau_id")
	private ChequeCadeau chequeCadeau;

	@Id
	@GeneratedValue
	@Column(name = "v_cheque_cadeau_massage_id")
	private int chequeCadeauRdvMassageId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_massage_id")
	private Massage massage;

	/**
	 * @return the chequeCadeau
	 */
	public ChequeCadeau getChequeCadeau() {
		return chequeCadeau;
	}

	/**
	 * @return the chequeCadeauRdvMassageId
	 */
	public int getChequeCadeauRdvMassageId() {
		return chequeCadeauRdvMassageId;
	}

	/**
	 * @return the massage
	 */
	public Massage getMassage() {
		return massage;
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
	public void setChequeCadeauRdvMassageId(int chequeCadeauRdvMassageId) {
		this.chequeCadeauRdvMassageId = chequeCadeauRdvMassageId;
	}

	/**
	 * @param massage the massage to set
	 */
	public void setMassage(Massage massage) {
		this.massage = massage;
	}
}
