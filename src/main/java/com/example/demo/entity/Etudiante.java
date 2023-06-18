package com.example.demo.entity;
// Generated 5 juin 2023, 20:00:47 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Etudiante generated by hbm2java
 */
@Entity
@Table(name = "etudiante", catalog = "pfe", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class Etudiante implements java.io.Serializable {

	private Integer idEtu;
	private Date dateInscpEtd;
	private Date dateNaissanceEtd;
	private String email;
	private Integer filier;
	private String nomEtu;
	private String numTele;
	private String password;
	private String prenomEtu;
	private String userName;
	private Set<NoteQuiz> noteQuizs = new HashSet<NoteQuiz>(0);
	private Set<EtudianteModule> etudianteModules = new HashSet<EtudianteModule>(0);

	public Etudiante() {
	}

	public Etudiante(String email, String nomEtu, String password, String prenomEtu, String user_name) {
		this.email = email;
		this.nomEtu = nomEtu;
		this.password = password;
		this.prenomEtu = prenomEtu;
		this.userName = userName;
	}

	public Etudiante(Date dateInscpEtd, Date dateNaissanceEtd, String email, Integer filier, String nomEtu,
					 String numTele, String password, String prenomEtu, String userName, Set<NoteQuiz> noteQuizs,
					 Set<EtudianteModule> etudianteModules) {
		this.dateInscpEtd = dateInscpEtd;
		this.dateNaissanceEtd = dateNaissanceEtd;
		this.email = email;
		this.filier = filier;
		this.nomEtu = nomEtu;
		this.numTele = numTele;
		this.password = password;
		this.prenomEtu = prenomEtu;
		this.userName = userName;
		this.noteQuizs = noteQuizs;
		this.etudianteModules = etudianteModules;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_etu", unique = true, nullable = false)
	public Integer getIdEtu() {
		return this.idEtu;
	}

	public void setIdEtu(Integer idEtu) {
		this.idEtu = idEtu;
	}


	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Date_inscp_etd", columnDefinition = "DATE DEFAULT CURRENT_DATE",nullable = true, length = 10)
	public Date getDateInscpEtd() {
		return this.dateInscpEtd;
	}

	public void setDateInscpEtd(Date dateInscpEtd) {
		this.dateInscpEtd = dateInscpEtd;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_naissance_etd", length = 10)
	public Date getDateNaissanceEtd() {
		return this.dateNaissanceEtd;
	}

	public void setDateNaissanceEtd(Date dateNaissanceEtd) {
		this.dateNaissanceEtd = dateNaissanceEtd;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "filier", nullable = true)
	public Integer getFilier() {
		return this.filier;
	}

	public void setFilier(Integer filier) {
		this.filier = filier;
	}

	@Column(name = "nom_etu", nullable = false)
	public String getNomEtu() {
		return this.nomEtu;
	}

	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}

	@Column(name = "num_tele")
	public String getNumTele() {
		return this.numTele;
	}

	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "prenom_etu", nullable = false)
	public String getPrenomEtu() {
		return this.prenomEtu;
	}

	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}

	@Column(name = "user_name", unique = true, nullable = false, length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etudiante")
	public Set<NoteQuiz> getNoteQuizs() {
		return this.noteQuizs;
	}

	public void setNoteQuizs(Set<NoteQuiz> noteQuizs) {
		this.noteQuizs = noteQuizs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etudiante")
	public Set<EtudianteModule> getEtudianteModules() {
		return this.etudianteModules;
	}

	public void setEtudianteModules(Set<EtudianteModule> etudianteModules) {
		this.etudianteModules = etudianteModules;
	}

}