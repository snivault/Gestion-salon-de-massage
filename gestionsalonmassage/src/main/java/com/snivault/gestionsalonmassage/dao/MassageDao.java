package com.snivault.gestionsalonmassage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snivault.gestionsalonmassage.model.Massage;

/**
 * Interface au dessus de {@link MassageCustomDao}. Cette dernière n'est qu'un
 * exemple pour savoir comment faire une méthode personnalisée que nous aurions
 * besoin de décrire dans une implémentation de DAO. Ici ce n'est pas le cas,
 * mais nous aurions pu créer une classe qui implémente MassageDao lui meme
 * implémentant cette interface
 * 
 * @author Nous
 *
 */
public interface MassageDao extends JpaRepository<Massage, Integer>, MassageCustomDao {

	@Override
	@EntityGraph(value = "massage.listbienfaits")
	List<Massage> findAll();
}
