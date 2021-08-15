package com.snivault.gestionsalonmassage.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("H")
@Table(name = "m_huile_massage")
public class HuileMassage extends ProduitFini {
	@Override
	public void methodeA() {
		// TODO mafactory à compléter
		System.out.println("A implémenter pour le produit fini");
	}
}
