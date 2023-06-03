package com.example.demo.entity;
// Generated 31 mai 2023, 18:41:19 by Hibernate Tools 4.3.5.Final


import jakarta.persistence.*;

/**
 * Question generated by hbm2java
 */
@Entity
@Table(name = "question", catalog = "pfe")
public class Question implements java.io.Serializable {

	private int idQst;
	private Quiz quiz;
	private String question;
	private String reponse;
	private float note;

	public Question() {
	}

	public Question(int idQst, Quiz quiz, String question, String reponse, float note) {
		this.idQst = idQst;
		this.quiz = quiz;
		this.question = question;
		this.reponse = reponse;
		this.note = note;
	}

	@Id

	@Column(name = "id_qst", unique = true, nullable = false)
	public int getIdQst() {
		return this.idQst;
	}

	public void setIdQst(int idQst) {
		this.idQst = idQst;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz", nullable = false)
	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Column(name = "Question", nullable = false)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "reponse", nullable = false)
	public String getReponse() {
		return this.reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	@Column(name = "note", nullable = false, precision = 12, scale = 0)
	public float getNote() {
		return this.note;
	}

	public void setNote(float note) {
		this.note = note;
	}

}
