package com.snivault.gestionsalonmassage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.snivault.gestionsalonmassage.model.ChequeCadeau;

public interface ChequeCadeauDao extends JpaRepository<ChequeCadeau, Integer> {
	/**
	 * Retourne les chèques cadeaux en cours, le montant du chèque et la somme des
	 * montants de chaque rendez-vous pris pour chaque chèque.
	 * 
	 * @return la liste des chèques cadeaux
	 */
	@Query(nativeQuery = true, value = "SELECT chq.*,chq.v_montant_encaisse as montant_cheque,sum(rdv.v_montant_encaisse) as total_encaisse FROM v_cheque_cadeau chq \r\n"
			+ "INNER JOIN v_cheque_cadeau_rdv_massage chrdv ON chrdv.v_cheque_cadeau_id=chq.v_vente_id\r\n" + "INNER JOIN v_rendez_vous_massage rdv ON rdv.v_vente_id=chrdv.v_rendez_vous_massage_id\r\n"
			+ "GROUP BY  chq.v_vente_id, chq.v_montant_encaisse\r\n" + "HAVING total_encaisse < montant_cheque\r\n" + "UNION\r\n" + "select chq2.*,chq2.v_montant_encaisse,0 FROM v_cheque_cadeau chq2 where chq2.v_vente_id not in\r\n"
			+ "(select v_cheque_cadeau_id FROM v_cheque_cadeau_rdv_massage);")
	List<Object[]> getChequesCadeauxEnCours();

	/**
	 * Retourne les chèques cadeaux terminés, le montant du chèque et la somme des
	 * montants de chaque rendez-vous pris pour chaque chèque.
	 * 
	 * @return la liste des chèques cadeaux
	 */
	@Query(nativeQuery = true, value = "SELECT chq.*,chq.v_montant_encaisse as montant_cheque,sum(rdv.v_montant_encaisse) as total_encaisse FROM v_cheque_cadeau chq \r\n"
			+ "INNER JOIN v_cheque_cadeau_rdv_massage chrdv ON chrdv.v_cheque_cadeau_id=chq.v_vente_id\r\n" + "INNER JOIN v_rendez_vous_massage rdv ON rdv.v_vente_id=chrdv.v_rendez_vous_massage_id\r\n"
			+ "GROUP BY  chq.v_vente_id, chq.v_montant_encaisse\r\n" + "HAVING total_encaisse = montant_cheque;")
	List<Object[]> getChequesCadeauxTermines();

	/**
	 * Retourne le dernier chèque cadeau acheté en date par un client.
	 * 
	 * @param clientId recherché
	 * @return le chèque cadeau, null si pas trouvé.
	 */
	@Query(value = "SELECT chq1 FROM ChequeCadeau chq1 WHERE chq1.dateVente=(SELECT max(chq2.dateVente) FROM ChequeCadeau chq2 WHERE chq2.client.clientId=:clientId)")
	ChequeCadeau getLastChequeCadeau(@Param(value = "clientId") Integer clientId);

}
