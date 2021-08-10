package com.snivault.gestionsalonmassage.factory;

import com.snivault.gestionsalonmassage.model.ProduitMixteAbstract;

public abstract class ProduitMixteFactoryAbstract {
	protected abstract ProduitMixteAbstract createProduitMixteA();

	public ProduitMixteAbstract getProduitMixteA() {
		return createProduitMixteA();
	}
}
