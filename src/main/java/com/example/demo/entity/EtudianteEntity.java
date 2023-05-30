package com.example.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Etudiante", schema = "Pfe", catalog = "")
public class EtudianteEntity {
    @Basic
    @Column(name = "id_etu")
    private int idEtu;
    @Basic
    @Column(name = "nom_etu")
    private int nomEtu;
    @Basic
    @Column(name = "prenom_etu")
    private int prenomEtu;
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
    @Column(name = "Date_naissance_etd")
    private Date dateNaissanceEtd;
    @Basic
    @Column(name = "Date_inscp_etd")
    private Date dateInscpEtd;
    @Basic
    @Column(name = "filier")
    private int filier;
    @Basic
    @Column(name = "Num_tele")
    private int numTele;
    @Basic
    @Column(name = "Note")
    private double note;
    @Basic
    @Column(name = "module")
    private int module;
    @Basic
    @Column(name = "message")
    private int message;
    @ManyToOne
    @JoinColumn(name = "filier", referencedColumnName = "id_fil", nullable = false)
    private FiliereEntity filiereByFilier;
    @ManyToOne
    @JoinColumn(name = "module", referencedColumnName = "id_modul", nullable = false)
    private ModuleEntity moduleByModule;
    @ManyToOne
    @JoinColumn(name = "message", referencedColumnName = "id_Msg", nullable = false)
    private MessageEntity messageByMessage;

    public int getIdEtu() {
        return idEtu;
    }

    public void setIdEtu(int idEtu) {
        this.idEtu = idEtu;
    }

    public int getNomEtu() {
        return nomEtu;
    }

    public void setNomEtu(int nomEtu) {
        this.nomEtu = nomEtu;
    }

    public int getPrenomEtu() {
        return prenomEtu;
    }

    public void setPrenomEtu(int prenomEtu) {
        this.prenomEtu = prenomEtu;
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

    public Date getDateNaissanceEtd() {
        return dateNaissanceEtd;
    }

    public void setDateNaissanceEtd(Date dateNaissanceEtd) {
        this.dateNaissanceEtd = dateNaissanceEtd;
    }

    public Date getDateInscpEtd() {
        return dateInscpEtd;
    }

    public void setDateInscpEtd(Date dateInscpEtd) {
        this.dateInscpEtd = dateInscpEtd;
    }

    public int getFilier() {
        return filier;
    }

    public void setFilier(int filier) {
        this.filier = filier;
    }

    public int getNumTele() {
        return numTele;
    }

    public void setNumTele(int numTele) {
        this.numTele = numTele;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
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

        EtudianteEntity that = (EtudianteEntity) o;

        if (idEtu != that.idEtu) return false;
        if (nomEtu != that.nomEtu) return false;
        if (prenomEtu != that.prenomEtu) return false;
        if (filier != that.filier) return false;
        if (numTele != that.numTele) return false;
        if (Double.compare(that.note, note) != 0) return false;
        if (module != that.module) return false;
        if (message != that.message) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (dateNaissanceEtd != null ? !dateNaissanceEtd.equals(that.dateNaissanceEtd) : that.dateNaissanceEtd != null)
            return false;
        if (dateInscpEtd != null ? !dateInscpEtd.equals(that.dateInscpEtd) : that.dateInscpEtd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idEtu;
        result = 31 * result + nomEtu;
        result = 31 * result + prenomEtu;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dateNaissanceEtd != null ? dateNaissanceEtd.hashCode() : 0);
        result = 31 * result + (dateInscpEtd != null ? dateInscpEtd.hashCode() : 0);
        result = 31 * result + filier;
        result = 31 * result + numTele;
        temp = Double.doubleToLongBits(note);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + module;
        result = 31 * result + message;
        return result;
    }

    public FiliereEntity getFiliereByFilier() {
        return filiereByFilier;
    }

    public void setFiliereByFilier(FiliereEntity filiereByFilier) {
        this.filiereByFilier = filiereByFilier;
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
