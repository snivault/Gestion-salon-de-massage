package com.snivault.gestionsalonmassage.dao;

import java.util.Date;

/**
 * Interface représentant la vue m_registre_achats_depenses_autres pour la
 * comptabilité.
 * 
 * @author Nous
 *
 */
public interface ViewRegistreAchatsDepensesAutresDao {
	int getACHAT_ID();

	Date getDATE_ACHAT();

	String getLIBELLE_MOYEN_PAIEMENT();

	String getLIBELLE_PRODUIT();

	float getMONTANT_ACHAT();

	String getNOM_FOURNISSEUR();

	String getREFERENCE_ACHAT();

	String getTYPE_ACHAT();
}
