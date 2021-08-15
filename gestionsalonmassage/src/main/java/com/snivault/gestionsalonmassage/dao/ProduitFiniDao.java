package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snivault.gestionsalonmassage.model.ProduitFini;

/**
 * Classe permettant d'agir sur la table ProduitFini.
 * 
 * @author Nous
 *
 */
public interface ProduitFiniDao extends JpaRepository<ProduitFini, Integer> {
	@Override
	@EntityGraph(value = "produitfini.listfournisseurs")
	ProduitFini getById(Integer produitId);
}
