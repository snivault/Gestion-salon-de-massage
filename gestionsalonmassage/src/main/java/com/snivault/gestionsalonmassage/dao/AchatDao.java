package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snivault.gestionsalonmassage.model.Achat;

public interface AchatDao extends JpaRepository<Achat, Integer> {
	@Override
	@EntityGraph(value = "achat.listproduits")
	Achat getById(Integer achatId);
}
