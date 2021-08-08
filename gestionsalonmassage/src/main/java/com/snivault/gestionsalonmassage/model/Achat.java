package com.snivault.gestionsalonmassage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Exemple de problématique (arthrose, manque de sommeil, surpoids...).
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_achat")
public class Achat {
	@Id
	@GeneratedValue
	@Column(name = "m_achat_id")
	private int achatId;

	@Column(name = "m_date_achat")
	private Date dateAchat;

	@Column(name = "m_montant")
	private float montant;

	/**
	 * @return the achatId
	 */
	public int getAchatId() {
		return achatId;
	}

	/**
	 * @return the dateAchat
	 */
	public Date getDateAchat() {
		return dateAchat;
	}

	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * @param achatId the achatId to set
	 */
	public void setAchatId(int achatId) {
		this.achatId = achatId;
	}

	/**
	 * @param dateAchat the dateAchat to set
	 */
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}

}
