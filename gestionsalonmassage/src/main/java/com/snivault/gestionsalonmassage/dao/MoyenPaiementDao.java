package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snivault.gestionsalonmassage.model.MoyenPaiement;

public interface MoyenPaiementDao extends JpaRepository<MoyenPaiement, Integer> {

}
