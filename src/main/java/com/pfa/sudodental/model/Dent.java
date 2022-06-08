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
public class Dent extends AbstractModel<Long> {
    private Long NumD;
    private String Genre;
    private String ActeD;
    private String EtatD;
    private String Description;
}
