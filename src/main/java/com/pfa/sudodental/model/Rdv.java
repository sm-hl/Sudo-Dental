package com.pfa.sudodental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Rdv extends AbstractModel<Long> {
    private String DateRdv;
    private String HeureRdv;
    private String HeureFin;
    private String Traitement;
    private Boolean Etat;

    @ManyToOne
    @JoinColumn(name ="patient_id")
    Patient patient;

    public String getDateRdv() {
        return DateRdv;
    }

    public void setDateRdv(String dateRdv) {
        DateRdv = dateRdv;
    }

    public String getHeureRdv() {
        return HeureRdv;
    }

    public void setHeureRdv(String heureRdv) {
        HeureRdv = heureRdv;
    }

    public String getHeureFin() {
        return HeureFin;
    }

    public void setHeureFin(String heureFin) {
        HeureFin = heureFin;
    }

    public String getTraitement() {
        return Traitement;
    }

    public void setTraitement(String traitement) {
        Traitement = traitement;
    }

    public Boolean getEtat() {
        return Etat;
    }

    public void setEtat(Boolean etat) {
        Etat = etat;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

