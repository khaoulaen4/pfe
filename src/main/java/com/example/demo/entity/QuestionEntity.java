package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Question", schema = "Pfe", catalog = "")
public class QuestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_qst")
    private int idQst;
    @Basic
    @Column(name = "Question")
    private String question;
    @Basic
    @Column(name = "reponse")
    private String reponse;
    @Basic
    @Column(name = "note")
    private double note;
    @Basic
    @Column(name = "quiz")
    private int quiz;
    @ManyToOne
    @JoinColumn(name = "quiz", referencedColumnName = "id_qz", nullable = false)
    private QuizEntity quizByQuiz;

    public int getIdQst() {
        return idQst;
    }

    public void setIdQst(int idQst) {
        this.idQst = idQst;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (idQst != that.idQst) return false;
        if (Double.compare(that.note, note) != 0) return false;
        if (quiz != that.quiz) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        if (reponse != null ? !reponse.equals(that.reponse) : that.reponse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idQst;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (reponse != null ? reponse.hashCode() : 0);
        temp = Double.doubleToLongBits(note);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quiz;
        return result;
    }

    public QuizEntity getQuizByQuiz() {
        return quizByQuiz;
    }

    public void setQuizByQuiz(QuizEntity quizByQuiz) {
        this.quizByQuiz = quizByQuiz;
    }
}
