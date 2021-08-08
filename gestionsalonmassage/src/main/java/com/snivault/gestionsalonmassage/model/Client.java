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
@Table(name = "c_client")
public class Client {
	@Column(name = "c_adresse")
	private String adresse;

	@Id
	@GeneratedValue
	@Column(name = "c_client_id")
	private int clientId;

	@Column(name = "c_mail")
	private String mail;

	@Column(name = "c_nom")
	private String nom;

	@Column(name = "c_prenom")
	private String prenom;

	@Column(name = "c_pseudo_facebook")
	private String pseudoFacebook;

	@Column(name = "c_telephone")
	private int telephone;

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the clientId
	 */
	public int getClientId() {
		return clientId;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the pseudoFacebook
	 */
	public String getPseudoFacebook() {
		return pseudoFacebook;
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
	 * @param clientId the clientId to set
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
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
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param pseudoFacebook the pseudoFacebook to set
	 */
	public void setPseudoFacebook(String pseudoFacebook) {
		this.pseudoFacebook = pseudoFacebook;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

}
