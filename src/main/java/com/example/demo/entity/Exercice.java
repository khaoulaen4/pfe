package com.example.demo.entity;
// Generated 5 juin 2023, 20:00:47 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Exercice generated by hbm2java
 */
@Entity
@Table(name = "exercice", catalog = "pfe")
public class Exercice implements java.io.Serializable {

	private Integer idEx;
	private Modul modul;
	private String nomEx;
	private Date dateAjoute;

	public Exercice() {
	}

	public Exercice(Modul modul, String nomEx, Date dateAjoute) {
		this.modul = modul;
		this.nomEx = nomEx;
		this.dateAjoute = dateAjoute;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ex", unique = true, nullable = false)
	public Integer getIdEx() {
		return this.idEx;
	}

	public void setIdEx(Integer idEx) {
		this.idEx = idEx;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module", nullable = false)
	public Modul getModul() {
		return this.modul;
	}

	public void setModul(Modul modul) {
		this.modul = modul;
	}

	@Column(name = "nom_ex", nullable = false, length = 45)
	public String getNomEx() {
		return this.nomEx;
	}

	public void setNomEx(String nomEx) {
		this.nomEx = nomEx;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_ajoute", nullable = false, length = 10)
	public Date getDateAjoute() {
		return this.dateAjoute;
	}

	public void setDateAjoute(Date dateAjoute) {
		this.dateAjoute = dateAjoute;
	}

}
