package com.snivault.gestionsalonmassage.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe représentant un rendez-vous de massage avec un client.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "v_rendez_vous_massage")
public class RendezVousMassage extends Vente {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "v_cheque_cadeau_id")
	private ChequeCadeau chequeCadeau;

	@Column(name = "v_heure")
	private Date heure;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_produit_id")
	private HuileMassage huileMassage;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "v_rendez_vous_massage_problematique", joinColumns = @JoinColumn(name = "v_vente_id"), inverseJoinColumns = @JoinColumn(name = "c_problematique_id"))
	private List<Problematique> listProblematiques;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_massage_id")
	private Massage massage;

	@Column(name = "v_remarque_masse")
	private Date remarqueMasse;

	@Column(name = "v_remarque_moi")
	private Date remarqueMoi;

	/**
	 * @return the chequeCadeau
	 */
	public ChequeCadeau getChequeCadeau() {
		return chequeCadeau;
	}

	/**
	 * @return the heure
	 */
	public Date getHeure() {
		return heure;
	}

	/**
	 * @return the huileMassage
	 */
	public HuileMassage getHuileMassage() {
		return huileMassage;
	}

	/**
	 * @return the listProblematiques
	 */
	public List<Problematique> getListProblematiques() {
		return listProblematiques;
	}

	/**
	 * @return the massage
	 */
	public Massage getMassage() {
		return massage;
	}

	/**
	 * @return the remarqueMasse
	 */
	public Date getRemarqueMasse() {
		return remarqueMasse;
	}

	/**
	 * @return the remarqueMoi
	 */
	public Date getRemarqueMoi() {
		return remarqueMoi;
	}

	/**
	 * @param chequeCadeau the chequeCadeau to set
	 */
	public void setChequeCadeau(ChequeCadeau chequeCadeau) {
		this.chequeCadeau = chequeCadeau;
	}

	/**
	 * @param heure the heure to set
	 */
	public void setHeure(Date heure) {
		this.heure = heure;
	}

	/**
	 * @param huileMassage the huileMassage to set
	 */
	public void setHuileMassage(HuileMassage huileMassage) {
		this.huileMassage = huileMassage;
	}

	/**
	 * @param listProblematiques the listProblematiques to set
	 */
	public void setListProblematiques(List<Problematique> listProblematiques) {
		this.listProblematiques = listProblematiques;
	}

	/**
	 * @param massage the massage to set
	 */
	public void setMassage(Massage massage) {
		this.massage = massage;
	}

	/**
	 * @param remarqueMasse the remarqueMasse to set
	 */
	public void setRemarqueMasse(Date remarqueMasse) {
		this.remarqueMasse = remarqueMasse;
	}

	/**
	 * @param remarqueMoi the remarqueMoi to set
	 */
	public void setRemarqueMoi(Date remarqueMoi) {
		this.remarqueMoi = remarqueMoi;
	}
}
