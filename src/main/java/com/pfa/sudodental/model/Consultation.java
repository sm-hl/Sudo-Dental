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
    private Set<Seance> seanceList=new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "certificat_id")
    private Set<Certificat> certificatSet=new HashSet<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "consultation_id")
    private Set<Ordonance> ordonanceList=new HashSet<>();
    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "acte_id")
    Acte acte;
}
