package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Module", schema = "Pfe", catalog = "")
public class ModuleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_modul")
    private int idModul;
    @Basic
    @Column(name = "nom_modul")
    private String nomModul;
    @Basic
    @Column(name = "filier")
    private String filier;
    @Basic
    @Column(name = "enseignante")
    private String enseignante;
    @OneToMany(mappedBy = "moduleByModule")
    private Collection<ChapitreEntity> chapitresByIdModul;
    @OneToMany(mappedBy = "moduleByModule")
    private Collection<EnseignantEntity> enseignantsByIdModul;
    @OneToMany(mappedBy = "moduleByModule")
    private Collection<EtudianteEntity> etudiantesByIdModul;
    @OneToMany(mappedBy = "moduleByModule")
    private Collection<ExerciceEntity> exercicesByIdModul;
    @OneToMany(mappedBy = "moduleByModule")
    private Collection<FiliereEntity> filieresByIdModul;
    @OneToMany(mappedBy = "moduleByModule")
    private Collection<QuizEntity> quizzesByIdModul;

    public int getIdModul() {
        return idModul;
    }

    public void setIdModul(int idModul) {
        this.idModul = idModul;
    }

    public String getNomModul() {
        return nomModul;
    }

    public void setNomModul(String nomModul) {
        this.nomModul = nomModul;
    }

    public String getFilier() {
        return filier;
    }

    public void setFilier(String filier) {
        this.filier = filier;
    }

    public String getEnseignante() {
        return enseignante;
    }

    public void setEnseignante(String enseignante) {
        this.enseignante = enseignante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleEntity that = (ModuleEntity) o;

        if (idModul != that.idModul) return false;
        if (nomModul != null ? !nomModul.equals(that.nomModul) : that.nomModul != null) return false;
        if (filier != null ? !filier.equals(that.filier) : that.filier != null) return false;
        if (enseignante != null ? !enseignante.equals(that.enseignante) : that.enseignante != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idModul;
        result = 31 * result + (nomModul != null ? nomModul.hashCode() : 0);
        result = 31 * result + (filier != null ? filier.hashCode() : 0);
        result = 31 * result + (enseignante != null ? enseignante.hashCode() : 0);
        return result;
    }

    public Collection<ChapitreEntity> getChapitresByIdModul() {
        return chapitresByIdModul;
    }

    public void setChapitresByIdModul(Collection<ChapitreEntity> chapitresByIdModul) {
        this.chapitresByIdModul = chapitresByIdModul;
    }

    public Collection<EnseignantEntity> getEnseignantsByIdModul() {
        return enseignantsByIdModul;
    }

    public void setEnseignantsByIdModul(Collection<EnseignantEntity> enseignantsByIdModul) {
        this.enseignantsByIdModul = enseignantsByIdModul;
    }

    public Collection<EtudianteEntity> getEtudiantesByIdModul() {
        return etudiantesByIdModul;
    }

    public void setEtudiantesByIdModul(Collection<EtudianteEntity> etudiantesByIdModul) {
        this.etudiantesByIdModul = etudiantesByIdModul;
    }

    public Collection<ExerciceEntity> getExercicesByIdModul() {
        return exercicesByIdModul;
    }

    public void setExercicesByIdModul(Collection<ExerciceEntity> exercicesByIdModul) {
        this.exercicesByIdModul = exercicesByIdModul;
    }

    public Collection<FiliereEntity> getFilieresByIdModul() {
        return filieresByIdModul;
    }

    public void setFilieresByIdModul(Collection<FiliereEntity> filieresByIdModul) {
        this.filieresByIdModul = filieresByIdModul;
    }

    public Collection<QuizEntity> getQuizzesByIdModul() {
        return quizzesByIdModul;
    }

    public void setQuizzesByIdModul(Collection<QuizEntity> quizzesByIdModul) {
        this.quizzesByIdModul = quizzesByIdModul;
    }
}
