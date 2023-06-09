package com.example.demo.entity;
// Generated 5 juin 2023, 20:00:47 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;
/**
 * Message generated by hbm2java
 */
@Entity
@Table(name = "message", catalog = "pfe")
public class Message implements java.io.Serializable {

	private Integer idMsg;
	private String contenue;
	private Date dateEnvoi;
	private int sender;
	private int receiver;

	public Message() {
	}

	public Message(String contenue, Date dateEnvoi, int sender, int receiver) {
		this.contenue = contenue;
		this.dateEnvoi = dateEnvoi;
		this.sender = sender;
		this.receiver = receiver;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Msg", unique = true, nullable = false)
	public Integer getIdMsg() {
		return this.idMsg;
	}

	public void setIdMsg(Integer idMsg) {
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

	@Column(name = "sender", nullable = false)
	public int getSender() {
		return this.sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	@Column(name = "receiver", nullable = false)
	public int getReceiver() {
		return this.receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

}
