package com.snivault.gestionsalonmassage.dao.service;

import java.util.List;

import com.snivault.gestionsalonmassage.enums.EtatChequeCadeauType;
import com.snivault.gestionsalonmassage.model.ChequeCadeau;

/**
 * Service pour gérer les transactions et requêtes concernant les ventes
 * (rendez-vous massage, vente d'huile, vente de chèque cadeau).
 * 
 * @author Nous
 *
 */
public interface VenteService {
	List<ChequeCadeau> consulterChequeCadeau(EtatChequeCadeauType etat, String nomClient, String nomPersonneAMasser);

}
