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
public class Certificat extends AbstractModel<Long> {
    private String Traitement;
    private String DateCer;
    private Long Nbrjour;
    private Date DebutCer;
    private Date finCer;
}
