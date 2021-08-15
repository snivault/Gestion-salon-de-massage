package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snivault.gestionsalonmassage.model.CarteFidelite;

public interface CarteFideliteDao extends JpaRepository<CarteFidelite, Integer> {
	@Override
	@EntityGraph(value = "cartefidelite.listcasecochee")
	CarteFidelite getById(Integer carteFideliteId);
}
