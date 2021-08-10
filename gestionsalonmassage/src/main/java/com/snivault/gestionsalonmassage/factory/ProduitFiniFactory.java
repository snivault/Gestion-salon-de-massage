package com.snivault.gestionsalonmassage.factory;

import com.snivault.gestionsalonmassage.model.ProduitFini;
import com.snivault.gestionsalonmassage.model.ProduitMixteAbstract;

public class ProduitFiniFactory extends ProduitMixteFactoryAbstract {

	@Override
	protected ProduitMixteAbstract createProduitMixteA() {
		// TODO mafactory à compléter
		return new ProduitFini();
	}

}
