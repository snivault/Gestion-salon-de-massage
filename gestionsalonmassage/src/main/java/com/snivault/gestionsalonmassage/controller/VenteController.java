package com.snivault.gestionsalonmassage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snivault.gestionsalonmassage.dao.ChequeCadeauDao;
import com.snivault.gestionsalonmassage.model.ChequeCadeau;

@RestController
@RequestMapping("api/v1/vente")
@CrossOrigin("*")
public class VenteController {
	@Autowired
	ChequeCadeauDao chequeCadeauDao;

	// TODO SNI : transformer Object par une classe de la vue qui correspondra au
	// tableau de chèques cadeaux
	public List<Object[]> consulterChequesCadeauxEnCours() {
		return chequeCadeauDao.getChequesCadeauxEnCours();
	}

	// TODO SNI : transformer Object par une classe de la vue qui correspondra au
	// tableau de chèques cadeaux
	public List<Object[]> consulterChequesCadeauxTermines() {
		return chequeCadeauDao.getChequesCadeauxTermines();
	}

	@GetMapping
	public List<ChequeCadeau> getChequesCadeaux() {
		return chequeCadeauDao.findAll();
	}
}
