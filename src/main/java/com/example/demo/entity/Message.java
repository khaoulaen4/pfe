package com.example.demo.entity;
// Generated 31 mai 2023, 18:41:19 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

/**
 * Message generated by hbm2java
 */
@Entity
@Table(name = "message", catalog = "pfe")
public class Message implements java.io.Serializable {

	private int idMsg;
	private String contenue;
	private Date dateEnvoi;
	private Set<Administrateur> administrateurs = new HashSet<Administrateur>(0);
	private Set<Enseignant> enseignants = new HashSet<Enseignant>(0);
	private Set<Etudiante> etudiantes = new HashSet<Etudiante>(0);

	public Message() {
	}

	public Message(int idMsg, String contenue, Date dateEnvoi) {
		this.idMsg = idMsg;
		this.contenue = contenue;
		this.dateEnvoi = dateEnvoi;
	}

	public Message(int idMsg, String contenue, Date dateEnvoi, Set<Administrateur> administrateurs,
			Set<Enseignant> enseignants, Set<Etudiante> etudiantes) {
		this.idMsg = idMsg;
		this.contenue = contenue;
		this.dateEnvoi = dateEnvoi;
		this.administrateurs = administrateurs;
		this.enseignants = enseignants;
		this.etudiantes = etudiantes;
	}

	@Id

	@Column(name = "id_Msg", unique = true, nullable = false)
	public int getIdMsg() {
		return this.idMsg;
	}

	public void setIdMsg(int idMsg) {
		this.idMsg = idMsg;
	}

	@Column(name = "Contenue", nullable = false)
	public String getContenue() {
		return this.contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateEnvoi", nullable = false, length = 10)
	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
	public Set<Administrateur> getAdministrateurs() {
		return this.administrateurs;
	}

	public void setAdministrateurs(Set<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
	public Set<Enseignant> getEnseignants() {
		return this.enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
	public Set<Etudiante> getEtudiantes() {
		return this.etudiantes;
	}

	public void setEtudiantes(Set<Etudiante> etudiantes) {
		this.etudiantes = etudiantes;
	}

}