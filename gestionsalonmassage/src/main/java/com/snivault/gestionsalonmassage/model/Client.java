package com.snivault.gestionsalonmassage.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe représentant un client du salon de massage.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "c_client")
@NamedEntityGraph(name = "client.listproblematiques", attributeNodes = @NamedAttributeNode("listProblematiques"))
@NamedEntityGraph(name = "client.listcasecochee", attributeNodes = @NamedAttributeNode("listCaseCochees"))
public class Client implements Serializable {

	/** Generated id. */
	private static final long serialVersionUID = -2809720185693987287L;

	@Column(name = "c_adresse")
	private String adresse;

	@Id
	@GeneratedValue
	@Column(name = "c_client_id")
	private Integer clientId;

	/**
	 * par défaut les OneToMany sont LAZY mais c'est juste pour que je m'en
	 * souvienne.
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private List<CaseCocheeFidelite> listCaseCochees;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "c_client_problematique", joinColumns = @JoinColumn(name = "c_client_id"), inverseJoinColumns = @JoinColumn(name = "c_problematique_id"))
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
	private Integer telephone;

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @return the listCaseCochees
	 */
	public List<CaseCocheeFidelite> getListCaseCochees() {
		return listCaseCochees;
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

	public String getNomPrenom() {
		if (!getNom().isEmpty() && !getPrenom().isEmpty()) {
			return new StringBuilder(Math.addExact(getNom().length(), getPrenom().length())).append(getNom()).append(" ").append(getPrenom()).toString();
		} else if (!getNom().isEmpty() && !getPrenom().isEmpty()) {
			return getNom();
		} else if (!getPrenom().isEmpty()) {
			return getPrenom();
		}
		return "";
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
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @param listCaseCochees the listCaseCochees to set
	 */
	public void setListCaseCochees(List<CaseCocheeFidelite> listCaseCochees) {
		this.listCaseCochees = listCaseCochees;
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
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

}
