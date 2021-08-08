package com.snivault.gestionsalonmassage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment la personne a connu le salon de massage.
 * 
 * @author Nous
 *
 */
@Entity
@Table(name = "m_massage")
public class Massage {
	@Column(name = "m_duree_prevue_m")
	private Date dureePrevue;

	@Column(name = "m_libelle")
	private String libelle;
	@Id
	@GeneratedValue
	@Column(name = "m_massage_id")

	private int massageId;
	@Column(name = "m_tarif_prevu")
	private float tarifPrevu;
}
