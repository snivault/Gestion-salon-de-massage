package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe représentant un client du salon de massage.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_fournisseur")
public class Fournisseur {
	@Column(name = "m_adresse")
	private String adresse;

	@Id
	@GeneratedValue
	@Column(name = "m_fournisseur_id")
	private int fournisseurId;

	@Column(name = "m_mail")
	private String mail;

	@Column(name = "m_nom")
	private String nom;

	@Column(name = "m_site_internet")
	private String siteInternet;

	@Column(name = "m_telephone")
	private int telephone;

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the fournisseurId
	 */
	public int getFournisseurId() {
		return fournisseurId;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the siteInternet
	 */
	public String getSiteInternet() {
		return siteInternet;
	}

	/**
	 * @return the telephone
	 */
	public int getTelephone() {
		return telephone;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param fournisseurId the fournisseurId to set
	 */
	public void setFournisseurId(int fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param siteInternet the siteInternet to set
	 */
	public void setSiteInternet(String siteInternet) {
		this.siteInternet = siteInternet;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

}
