package com.snivault.gestionsalonmassage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.snivault.gestionsalonmassage.dao.ChequeCadeauDao;

@Controller
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
}
