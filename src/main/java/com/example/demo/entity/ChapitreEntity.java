package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Chapitre", schema = "Pfe", catalog = "")
public class ChapitreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_chpt")
    private int idChpt;
    @Basic
    @Column(name = "titre")
    private String titre;
    @Basic
    @Column(name = "module")
    private int module;
    @Basic
    @Column(name = "Date_ajoute")
    private Date dateAjoute;
    @ManyToOne
    @JoinColumn(name = "module", referencedColumnName = "id_modul", nullable = false)
    private ModuleEntity moduleByModule;

    public int getIdChpt() {
        return idChpt;
    }

    public void setIdChpt(int idChpt) {
        this.idChpt = idChpt;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

        ChapitreEntity that = (ChapitreEntity) o;

        if (idChpt != that.idChpt) return false;
        if (module != that.module) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (dateAjoute != null ? !dateAjoute.equals(that.dateAjoute) : that.dateAjoute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idChpt;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
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
