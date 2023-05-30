package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "message", schema = "Pfe", catalog = "")
public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Msg")
    private int idMsg;
    @Basic
    @Column(name = "Contenue")
    private String contenue;
    @Basic
    @Column(name = "DateEnvoi")
    private Date dateEnvoi;
    @OneToMany(mappedBy = "messageByMessage")
    private Collection<AdministrateurEntity> administrateursByIdMsg;
    @OneToMany(mappedBy = "messageByMessage")
    private Collection<EnseignantEntity> enseignantsByIdMsg;
    @OneToMany(mappedBy = "messageByMessage")
    private Collection<EtudianteEntity> etudiantesByIdMsg;

    public int getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(int idMsg) {
        this.idMsg = idMsg;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (idMsg != that.idMsg) return false;
        if (contenue != null ? !contenue.equals(that.contenue) : that.contenue != null) return false;
        if (dateEnvoi != null ? !dateEnvoi.equals(that.dateEnvoi) : that.dateEnvoi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMsg;
        result = 31 * result + (contenue != null ? contenue.hashCode() : 0);
        result = 31 * result + (dateEnvoi != null ? dateEnvoi.hashCode() : 0);
        return result;
    }

    public Collection<AdministrateurEntity> getAdministrateursByIdMsg() {
        return administrateursByIdMsg;
    }

    public void setAdministrateursByIdMsg(Collection<AdministrateurEntity> administrateursByIdMsg) {
        this.administrateursByIdMsg = administrateursByIdMsg;
    }

    public Collection<EnseignantEntity> getEnseignantsByIdMsg() {
        return enseignantsByIdMsg;
    }

    public void setEnseignantsByIdMsg(Collection<EnseignantEntity> enseignantsByIdMsg) {
        this.enseignantsByIdMsg = enseignantsByIdMsg;
    }

    public Collection<EtudianteEntity> getEtudiantesByIdMsg() {
        return etudiantesByIdMsg;
    }

    public void setEtudiantesByIdMsg(Collection<EtudianteEntity> etudiantesByIdMsg) {
        this.etudiantesByIdMsg = etudiantesByIdMsg;
    }
}
