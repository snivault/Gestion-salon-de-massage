package com.snivault.gestionsalonmassage.dao;

import java.util.Date;

/**
 * Interface représentant la vue v_ventes_chq_rdv_produit pour la comptabilité.
 * 
 * @author Nous
 *
 */
public interface ViewVentesChqRdvProduitDao {
	Date getDATE_VENTE();

	String getLIBELLE_MOYEN_PAIEMENT();

	float getMONTANT_ENCAISSE();

	String getNOMPRENOM_CLIENT();

	String getTYPE_VENTE();

	int getVENTE_ID();

}
