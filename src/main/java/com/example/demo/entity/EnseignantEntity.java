package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Enseignant", schema = "Pfe", catalog = "")
public class EnseignantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_eng")
    private int idEng;
    @Basic
    @Column(name = "nom_eng")
    private String nomEng;
    @Basic
    @Column(name = "prenom_eng")
    private String prenomEng;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "User_Name")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "Date_naissance_eng")
    private Date dateNaissanceEng;
    @Basic
    @Column(name = "Date_inscp_eng")
    private Date dateInscpEng;
    @Basic
    @Column(name = "num_tele")
    private int numTele;
    @Basic
    @Column(name = "module")
    private int module;
    @Basic
    @Column(name = "message")
    private int message;
    @ManyToOne
    @JoinColumn(name = "module", referencedColumnName = "id_modul", nullable = false)
    private ModuleEntity moduleByModule;
    @ManyToOne
    @JoinColumn(name = "message", referencedColumnName = "id_Msg", nullable = false)
    private MessageEntity messageByMessage;

    public int getIdEng() {
        return idEng;
    }

    public void setIdEng(int idEng) {
        this.idEng = idEng;
    }

    public String getNomEng() {
        return nomEng;
    }

    public void setNomEng(String nomEng) {
        this.nomEng = nomEng;
    }

    public String getPrenomEng() {
        return prenomEng;
    }

    public void setPrenomEng(String prenomEng) {
        this.prenomEng = prenomEng;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissanceEng() {
        return dateNaissanceEng;
    }

    public void setDateNaissanceEng(Date dateNaissanceEng) {
        this.dateNaissanceEng = dateNaissanceEng;
    }

    public Date getDateInscpEng() {
        return dateInscpEng;
    }

    public void setDateInscpEng(Date dateInscpEng) {
        this.dateInscpEng = dateInscpEng;
    }

    public int getNumTele() {
        return numTele;
    }

    public void setNumTele(int numTele) {
        this.numTele = numTele;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnseignantEntity that = (EnseignantEntity) o;

        if (idEng != that.idEng) return false;
        if (numTele != that.numTele) return false;
        if (module != that.module) return false;
        if (message != that.message) return false;
        if (nomEng != null ? !nomEng.equals(that.nomEng) : that.nomEng != null) return false;
        if (prenomEng != null ? !prenomEng.equals(that.prenomEng) : that.prenomEng != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (dateNaissanceEng != null ? !dateNaissanceEng.equals(that.dateNaissanceEng) : that.dateNaissanceEng != null)
            return false;
        if (dateInscpEng != null ? !dateInscpEng.equals(that.dateInscpEng) : that.dateInscpEng != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEng;
        result = 31 * result + (nomEng != null ? nomEng.hashCode() : 0);
        result = 31 * result + (prenomEng != null ? prenomEng.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dateNaissanceEng != null ? dateNaissanceEng.hashCode() : 0);
        result = 31 * result + (dateInscpEng != null ? dateInscpEng.hashCode() : 0);
        result = 31 * result + numTele;
        result = 31 * result + module;
        result = 31 * result + message;
        return result;
    }

    public ModuleEntity getModuleByModule() {
        return moduleByModule;
    }

    public void setModuleByModule(ModuleEntity moduleByModule) {
        this.moduleByModule = moduleByModule;
    }

    public MessageEntity getMessageByMessage() {
        return messageByMessage;
    }

    public void setMessageByMessage(MessageEntity messageByMessage) {
        this.messageByMessage = messageByMessage;
    }
}
