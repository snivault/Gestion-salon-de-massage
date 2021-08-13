package com.snivault.gestionsalonmassage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Case cochée d'une carte de fidélité propre à un client.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "v_case_cochee_fidelite")
public class CaseCocheeFidelite {
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "v_carte_fidelite_id")
	private CarteFidelite carteFidelite;

	@Id
	@GeneratedValue
	@Column(name = "v_case_cochee_fidelite_id")
	private int caseCocheeFideliteId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_massage_id")
	private Massage massage;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "m_produit_fini_id")
	private ProduitFini produitFini;

	/**
	 * @return the carteFidelite
	 */
	public CarteFidelite getCarteFidelite() {
		return carteFidelite;
	}

	/**
	 * @return the caseCocheeFideliteId
	 */
	public int getCaseCocheeFideliteId() {
		return caseCocheeFideliteId;
	}

	/**
	 * @return the massage
	 */
	public Massage getMassage() {
		return massage;
	}

	/**
	 * @return the produitFini
	 */
	public ProduitFini getProduitFini() {
		return produitFini;
	}

	/**
	 * @param carteFidelite the carteFidelite to set
	 */
	public void setCarteFidelite(CarteFidelite carteFidelite) {
		this.carteFidelite = carteFidelite;
	}

	/**
	 * @param caseCocheeFideliteId the caseCocheeFideliteId to set
	 */
	public void setCaseCocheeFideliteId(int caseCocheeId) {
		this.caseCocheeFideliteId = caseCocheeId;
	}

	/**
	 * @param massage the massage to set
	 */
	public void setMassage(Massage massage) {
		this.massage = massage;
	}

	/**
	 * @param produitFini the produitFini to set
	 */
	public void setProduitFini(ProduitFini produitFini) {
		this.produitFini = produitFini;
	}

}
