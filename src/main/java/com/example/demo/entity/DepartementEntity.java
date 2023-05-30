package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Departement", schema = "Pfe", catalog = "")
public class DepartementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dep")
    private int idDep;
    @Basic
    @Column(name = "nom_dep")
    private String nomDep;
    @OneToMany(mappedBy = "departementByDepartement")
    private Collection<FiliereEntity> filieresByIdDep;

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartementEntity that = (DepartementEntity) o;

        if (idDep != that.idDep) return false;
        if (nomDep != null ? !nomDep.equals(that.nomDep) : that.nomDep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDep;
        result = 31 * result + (nomDep != null ? nomDep.hashCode() : 0);
        return result;
    }

    public Collection<FiliereEntity> getFilieresByIdDep() {
        return filieresByIdDep;
    }

    public void setFilieresByIdDep(Collection<FiliereEntity> filieresByIdDep) {
        this.filieresByIdDep = filieresByIdDep;
    }
}
