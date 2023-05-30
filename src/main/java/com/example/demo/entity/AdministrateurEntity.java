package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Administrateur", schema = "Pfe", catalog = "")
public class AdministrateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ad")
    private int idAd;
    @Basic
    @Column(name = "nom_adm")
    private String nomAdm;
    @Basic
    @Column(name = "prenom_adm")
    private String prenomAdm;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "UserName")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "Date_naissence_adm")
    private Date dateNaissenceAdm;
    @Basic
    @Column(name = "Date_inscp_adm")
    private Date dateInscpAdm;
    @Basic
    @Column(name = "num_tele")
    private int numTele;
    @Basic
    @Column(name = "message")
    private int message;
    @ManyToOne
    @JoinColumn(name = "message", referencedColumnName = "id_Msg", nullable = false)
    private MessageEntity messageByMessage;

    public int getIdAd() {
        return idAd;
    }

    public void setIdAd(int idAd) {
        this.idAd = idAd;
    }

    public String getNomAdm() {
        return nomAdm;
    }

    public void setNomAdm(String nomAdm) {
        this.nomAdm = nomAdm;
    }

    public String getPrenomAdm() {
        return prenomAdm;
    }

    public void setPrenomAdm(String prenomAdm) {
        this.prenomAdm = prenomAdm;
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

    public Date getDateNaissenceAdm() {
        return dateNaissenceAdm;
    }

    public void setDateNaissenceAdm(Date dateNaissenceAdm) {
        this.dateNaissenceAdm = dateNaissenceAdm;
    }

    public Date getDateInscpAdm() {
        return dateInscpAdm;
    }

    public void setDateInscpAdm(Date dateInscpAdm) {
        this.dateInscpAdm = dateInscpAdm;
    }

    public int getNumTele() {
        return numTele;
    }

    public void setNumTele(int numTele) {
        this.numTele = numTele;
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

        AdministrateurEntity that = (AdministrateurEntity) o;

        if (idAd != that.idAd) return false;
        if (numTele != that.numTele) return false;
        if (message != that.message) return false;
        if (nomAdm != null ? !nomAdm.equals(that.nomAdm) : that.nomAdm != null) return false;
        if (prenomAdm != null ? !prenomAdm.equals(that.prenomAdm) : that.prenomAdm != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (dateNaissenceAdm != null ? !dateNaissenceAdm.equals(that.dateNaissenceAdm) : that.dateNaissenceAdm != null)
            return false;
        if (dateInscpAdm != null ? !dateInscpAdm.equals(that.dateInscpAdm) : that.dateInscpAdm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAd;
        result = 31 * result + (nomAdm != null ? nomAdm.hashCode() : 0);
        result = 31 * result + (prenomAdm != null ? prenomAdm.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dateNaissenceAdm != null ? dateNaissenceAdm.hashCode() : 0);
        result = 31 * result + (dateInscpAdm != null ? dateInscpAdm.hashCode() : 0);
        result = 31 * result + numTele;
        result = 31 * result + message;
        return result;
    }

    public MessageEntity getMessageByMessage() {
        return messageByMessage;
    }

    public void setMessageByMessage(MessageEntity messageByMessage) {
        this.messageByMessage = messageByMessage;
    }
}
