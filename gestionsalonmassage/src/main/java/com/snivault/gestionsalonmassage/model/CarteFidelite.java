package com.snivault.gestionsalonmassage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Carte de fidélité propre à un client.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "v_carte_fidelite")
public class CarteFidelite {
	@Id
	@GeneratedValue
	@Column(name = "v_carte_fidelite_id")
	private int carteFideliteId;

	/**
	 * par défaut les OneToMany sont LAZY mais c'est juste pour que je m'en
	 * souvienne.
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "v_case_cochee_fidelite_id")
	private List<CaseCocheeFidelite> listCaseCochees;

	/**
	 * @return the carteFideliteId
	 */
	public int getCarteFideliteId() {
		return carteFideliteId;
	}

	/**
	 * @param carteFideliteId the carteFideliteId to set
	 */
	public void setCarteFideliteId(int carteFideliteId) {
		this.carteFideliteId = carteFideliteId;
	}
}
