package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Chèque cadeau qu'offre un client à une personne (qui peut être un client ou
 * non : dans ce cas pourQui est un texte libre représentant un nom et/ou un
 * prénom).
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "v_cheque_cadeau")
public class ChequeCadeau extends Vente {

	/**
	 * Soit pourQui renseigné car ce n'est pas un client, soit pourQuelClient
	 * représentant un client.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_pour_quel_client_id")
	private Client pourQuelClient;

	/**
	 * Soit pourQui renseigné car ce n'est pas un client, soit pourQuelClient
	 * représentant un client.
	 */
	@Column(name = "v_pour_qui")
	private String pourQui;

	/**
	 * @return the pourQuelClient
	 */
	public Client getPourQuelClient() {
		return pourQuelClient;
	}

	/**
	 * @return the pourQui
	 */
	public String getPourQui() {
		return pourQui;
	}

	/**
	 * @param pourQuelClient the pourQuelClient to set
	 */
	public void setPourQuelClient(Client pourQuelClient) {
		this.pourQuelClient = pourQuelClient;
	}

	/**
	 * @param pourQui the pourQui to set
	 */
	public void setPourQui(String pourQui) {
		this.pourQui = pourQui;
	}
}
