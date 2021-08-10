package com.snivault.gestionsalonmassage.factory;

import com.snivault.gestionsalonmassage.model.Massage;
import com.snivault.gestionsalonmassage.model.ProduitMixteAbstract;

public class MassageFactory extends ProduitMixteFactoryAbstract {

	@Override
	protected ProduitMixteAbstract createProduitMixteA() {
		// TODO mafactory à compléter
		return new Massage();
	}

}
