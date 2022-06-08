package com.pfa.sudodental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Acte extends AbstractModel<Long> {
    private String NomA;
    private Long NbrSce;
    private Long NbrHPerSce;
    private Float Montant;
}
