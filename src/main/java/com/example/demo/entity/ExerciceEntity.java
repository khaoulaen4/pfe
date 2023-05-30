package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Exercice", schema = "Pfe", catalog = "")
public class ExerciceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ex")
    private int idEx;
    @Basic
    @Column(name = "nom_ex")
    private String nomEx;
    @Basic
    @Column(name = "module")
    private int module;
    @Basic
    @Column(name = "Date_ajoute")
    private Date dateAjoute;
    @ManyToOne
    @JoinColumn(name = "module", referencedColumnName = "id_modul", nullable = false)
    private ModuleEntity moduleByModule;

    public int getIdEx() {
        return idEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public String getNomEx() {
        return nomEx;
    }

    public void setNomEx(String nomEx) {
        this.nomEx = nomEx;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public Date getDateAjoute() {
        return dateAjoute;
    }

    public void setDateAjoute(Date dateAjoute) {
        this.dateAjoute = dateAjoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExerciceEntity that = (ExerciceEntity) o;

        if (idEx != that.idEx) return false;
        if (module != that.module) return false;
        if (nomEx != null ? !nomEx.equals(that.nomEx) : that.nomEx != null) return false;
        if (dateAjoute != null ? !dateAjoute.equals(that.dateAjoute) : that.dateAjoute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEx;
        result = 31 * result + (nomEx != null ? nomEx.hashCode() : 0);
        result = 31 * result + module;
        result = 31 * result + (dateAjoute != null ? dateAjoute.hashCode() : 0);
        return result;
    }

    public ModuleEntity getModuleByModule() {
        return moduleByModule;
    }

    public void setModuleByModule(ModuleEntity moduleByModule) {
        this.moduleByModule = moduleByModule;
    }
}
