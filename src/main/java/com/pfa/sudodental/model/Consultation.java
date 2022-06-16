package com.pfa.sudodental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Consultation extends AbstractModel<Long> {
    private String DateC;
    private Long NbrSeance;
    private Float Montant;
    private Boolean EtatReglement;
    private Float MontantPaye;
@OneToMany(
       cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
)
@JoinColumn(name = "consultation_id")
    private List<Seance> seanceList=new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "certificat_id")
    private List<Certificat> certificatSet=new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "consultation_id")
    private List<Ordonance> ordonanceList=new ArrayList<>();
    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "acte_id")
    Acte acte;
}
