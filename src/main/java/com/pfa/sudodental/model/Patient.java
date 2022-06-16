package com.pfa.sudodental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends AbstractModel<Long> {
    private String Nom;
    private String Cin;
    private String Prenom;
    private String DateNaiss;
    private String Sex;
    private String TeleM1;
    private String Profession;
    private String Email;
    private String TeleM2;
    private String TeleF;
    private String Adresse;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "patient_id")
    private List<Consultation> consultationSet=new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "patient_id")
    private List<Dent> dentList=new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy="patient"
    )
    private List<Rdv> rdvSet=new ArrayList<>();

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "DM_id")
    private DossierMedicale dossierMedicale;

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getDateNaiss() {
        return DateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        DateNaiss = dateNaiss;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getTeleM1() {
        return TeleM1;
    }

    public void setTeleM1(String teleM1) {
        TeleM1 = teleM1;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTeleM2() {
        return TeleM2;
    }

    public void setTeleM2(String teleM2) {
        TeleM2 = teleM2;
    }

    public String getTeleF() {
        return TeleF;
    }

    public void setTeleF(String teleF) {
        TeleF = teleF;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public List<Consultation> getConsultationSet() {
        return consultationSet;
    }

    public void setConsultationSet(List<Consultation> consultationSet) {
        this.consultationSet = consultationSet;
    }

    public List<Dent> getDentList() {
        return dentList;
    }

    public void setDentList(List<Dent> dentList) {
        this.dentList = dentList;
    }

    public List<Rdv> getRdvSet() {
        return rdvSet;
    }

    public void setRdvSet(List<Rdv> rdvSet) {
        this.rdvSet = rdvSet;
    }

    public DossierMedicale getDossierMedicale() {
        return dossierMedicale;
    }

    public void setDossierMedicale(DossierMedicale dossierMedicale) {
        this.dossierMedicale = dossierMedicale;
    }

    public boolean modifierDent(Dent dent){
        for (Dent dent1 : this.getDentList()) {
            if (dent1.getNumD()==dent.getNumD()) {
                dent1.setActeD(dent.getActeD());
                dent1.setGenre(dent.getGenre());
                dent1.setDescription(dent.getDescription());
                dent1.setEtatD(dent.getEtatD());
                return true;
            }
        }
       return false;
    }
}

