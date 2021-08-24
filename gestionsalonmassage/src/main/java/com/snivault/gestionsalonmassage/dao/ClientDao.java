package com.snivault.gestionsalonmassage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snivault.gestionsalonmassage.model.Client;

/**
 * Interface d'accès à la table représentant les clients du salon de massage.
 * 
 * @author Nous
 *
 */
@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

	@Override
	@EntityGraph(value = "client.listproblematiques")
	List<Client> findAll();

	@Override
	Client getById(Integer clientId);

}
