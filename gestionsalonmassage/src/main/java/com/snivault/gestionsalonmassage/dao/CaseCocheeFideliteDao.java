package com.snivault.gestionsalonmassage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.snivault.gestionsalonmassage.model.CarteFidelite;
import com.snivault.gestionsalonmassage.model.CaseCocheeFidelite;

public interface CaseCocheeFideliteDao extends JpaRepository<CarteFidelite, Integer> {

	@Query("SELECT cas2 FROM CaseCocheeFidelite cas2 WHERE cas2.chequeCadeau.venteId=:chequeCadeauId")
	CaseCocheeFidelite getCaseByVenteChequeCadeauId(@Param(value = "chequeCadeauId") int chequeCadeauId);

	@Query("SELECT cas1 FROM CaseCocheeFidelite cas1 WHERE cas1.rendezVousMassage.venteId=:rendezVousMassageId")
	CaseCocheeFidelite getCaseByVenteRdvId(@Param(value = "rendezVousMassageId") int rendezVousMassageId);

}
