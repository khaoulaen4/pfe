package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Filiere", schema = "Pfe", catalog = "")
public class FiliereEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fil")
    private int idFil;
    @Basic
    @Column(name = "Nom_fil")
    private String nomFil;
    @Basic
    @Column(name = "Code_fil")
    private String codeFil;
    @Basic
    @Column(name = "Departement")
    private int departement;
    @Basic
    @Column(name = "module")
    private int module;
    @OneToMany(mappedBy = "filiereByFilier")
    private Collection<EtudianteEntity> etudiantesByIdFil;
    @ManyToOne
    @JoinColumn(name = "Departement", referencedColumnName = "id_dep", nullable = false)
    private DepartementEntity departementByDepartement;
    @ManyToOne
    @JoinColumn(name = "module", referencedColumnName = "id_modul", nullable = false)
    private ModuleEntity moduleByModule;

    public int getIdFil() {
        return idFil;
    }

    public void setIdFil(int idFil) {
        this.idFil = idFil;
    }

    public String getNomFil() {
        return nomFil;
    }

    public void setNomFil(String nomFil) {
        this.nomFil = nomFil;
    }

    public String getCodeFil() {
        return codeFil;
    }

    public void setCodeFil(String codeFil) {
        this.codeFil = codeFil;
    }

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
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

        FiliereEntity that = (FiliereEntity) o;

        if (idFil != that.idFil) return false;
        if (departement != that.departement) return false;
        if (module != that.module) return false;
        if (nomFil != null ? !nomFil.equals(that.nomFil) : that.nomFil != null) return false;
        if (codeFil != null ? !codeFil.equals(that.codeFil) : that.codeFil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFil;
        result = 31 * result + (nomFil != null ? nomFil.hashCode() : 0);
        result = 31 * result + (codeFil != null ? codeFil.hashCode() : 0);
        result = 31 * result + departement;
        result = 31 * result + module;
        return result;
    }

    public Collection<EtudianteEntity> getEtudiantesByIdFil() {
        return etudiantesByIdFil;
    }

    public void setEtudiantesByIdFil(Collection<EtudianteEntity> etudiantesByIdFil) {
        this.etudiantesByIdFil = etudiantesByIdFil;
    }

    public DepartementEntity getDepartementByDepartement() {
        return departementByDepartement;
    }

    public void setDepartementByDepartement(DepartementEntity departementByDepartement) {
        this.departementByDepartement = departementByDepartement;
    }

    public ModuleEntity getModuleByModule() {
        return moduleByModule;
    }

    public void setModuleByModule(ModuleEntity moduleByModule) {
        this.moduleByModule = moduleByModule;
    }
}
