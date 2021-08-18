package com.snivault.gestionsalonmassage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
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
@NamedEntityGraph(name = "cartefidelite.listcasecochee", attributeNodes = @NamedAttributeNode("listCaseCochees"))
public class CarteFidelite {
	@Id
	@GeneratedValue
	@Column(name = "v_carte_fidelite_id")
	private Integer carteFideliteId;

	/**
	 * par défaut les OneToMany sont LAZY mais c'est juste pour que je m'en
	 * souvienne.
	 */
	@OneToMany(fetch = FetchType.LAZY, targetEntity = CaseCocheeFidelite.class, mappedBy = "carteFidelite")
	private List<CaseCocheeFidelite> listCaseCochees;

	public CarteFidelite() {
		listCaseCochees = new ArrayList<>();
	}

	/**
	 * @return the carteFideliteId
	 */
	public Integer getCarteFideliteId() {
		return carteFideliteId;
	}

	/**
	 * @return the listCaseCochees
	 */
	public List<CaseCocheeFidelite> getListCaseCochees() {
		return listCaseCochees;
	}

	/**
	 * @param carteFideliteId the carteFideliteId to set
	 */
	public void setCarteFideliteId(Integer carteFideliteId) {
		this.carteFideliteId = carteFideliteId;
	}

	/**
	 * @param listCaseCochees the listCaseCochees to set
	 */
	public void setListCaseCochees(List<CaseCocheeFidelite> listCaseCochees) {
		this.listCaseCochees = listCaseCochees;
	}
}
