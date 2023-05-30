package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Quiz", schema = "Pfe", catalog = "")
public class QuizEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_qz")
    private int idQz;
    @Basic
    @Column(name = "titre")
    private String titre;
    @Basic
    @Column(name = "Date_ajoute")
    private Date dateAjoute;
    @Basic
    @Column(name = "Date_limite")
    private Date dateLimite;
    @Basic
    @Column(name = "module")
    private int module;
    @OneToMany(mappedBy = "quizByQuiz")
    private Collection<QuestionEntity> questionsByIdQz;
    @ManyToOne
    @JoinColumn(name = "module", referencedColumnName = "id_modul", nullable = false)
    private ModuleEntity moduleByModule;

    public int getIdQz() {
        return idQz;
    }

    public void setIdQz(int idQz) {
        this.idQz = idQz;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateAjoute() {
        return dateAjoute;
    }

    public void setDateAjoute(Date dateAjoute) {
        this.dateAjoute = dateAjoute;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizEntity that = (QuizEntity) o;

        if (idQz != that.idQz) return false;
        if (module != that.module) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (dateAjoute != null ? !dateAjoute.equals(that.dateAjoute) : that.dateAjoute != null) return false;
        if (dateLimite != null ? !dateLimite.equals(that.dateLimite) : that.dateLimite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQz;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + (dateAjoute != null ? dateAjoute.hashCode() : 0);
        result = 31 * result + (dateLimite != null ? dateLimite.hashCode() : 0);
        result = 31 * result + module;
        return result;
    }

    public Collection<QuestionEntity> getQuestionsByIdQz() {
        return questionsByIdQz;
    }

    public void setQuestionsByIdQz(Collection<QuestionEntity> questionsByIdQz) {
        this.questionsByIdQz = questionsByIdQz;
    }

    public ModuleEntity getModuleByModule() {
        return moduleByModule;
    }

    public void setModuleByModule(ModuleEntity moduleByModule) {
        this.moduleByModule = moduleByModule;
    }
}
