package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Fournisseur du salon (ex : Naissance pour les huiles).
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
	private Integer fournisseurId;

	@Column(name = "m_mail")
	private String mail;

	@Column(name = "m_nom")
	private String nom;

	@Column(name = "m_site_Integerernet")
	private String siteInternet;

	@Column(name = "m_telephone")
	private Integer telephone;

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the fournisseurId
	 */
	public Integer getFournisseurId() {
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
	public Integer getTelephone() {
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
	public void setFournisseurId(Integer fournisseurId) {
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
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

}
