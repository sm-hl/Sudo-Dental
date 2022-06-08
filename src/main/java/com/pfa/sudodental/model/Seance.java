package com.pfa.sudodental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Seance extends AbstractModel<Long> {
    private Float MontantSc;
    private String DateSc;
    private String Description;
 @OneToOne(
         cascade=CascadeType.ALL,
         orphanRemoval = true,
         fetch = FetchType.LAZY
 )
   @JoinColumn(name = "reglement_id")
    Reglement reglement;
}