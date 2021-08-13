package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snivault.gestionsalonmassage.model.Bienfait;

public interface BienfaitDao extends JpaRepository<Bienfait, Integer> {
	@Override
	@EntityGraph(value = "bienfait.listproblematiques")
	Bienfait getById(Integer bienfaitId);
}
