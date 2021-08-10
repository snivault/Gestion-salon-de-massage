package com.snivault.gestionsalonmassage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_carte_fidelite_id")
	private CarteFidelite carteFidelite;

	@Id
	@GeneratedValue
	@Column(name = "c_client_id")
	private int clientId;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "c_problematique_id")
	private List<Problematique> listProblematiques;

	@Column(name = "c_mail")
	private String mail;

	@Column(name = "c_nom")
	private String nom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_origine_contact_id")
	private OrigineContact origineContact;

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
	 * @return the carteFidelite
	 */
	public CarteFidelite getCarteFidelite() {
		return carteFidelite;
	}

	/**
	 * @return the clientId
	 */
	public int getClientId() {
		return clientId;
	}

	/**
	 * @return the listProblematiques
	 */
	public List<Problematique> getListProblematiques() {
		return listProblematiques;
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
	 * @return the origineContact
	 */
	public OrigineContact getOrigineContact() {
		return origineContact;
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
	 * @param carteFidelite the carteFidelite to set
	 */
	public void setCarteFidelite(CarteFidelite carteFidelite) {
		this.carteFidelite = carteFidelite;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	/**
	 * @param listProblematiques the listProblematiques to set
	 */
	public void setListProblematiques(List<Problematique> listProblematiques) {
		this.listProblematiques = listProblematiques;
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
	 * @param origineContact the origineContact to set
	 */
	public void setOrigineContact(OrigineContact origineContact) {
		this.origineContact = origineContact;
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
