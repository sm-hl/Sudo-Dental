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
public class Medicament extends AbstractModel<Long> {
    private String NomM;
    private String Type;
    private Long Nbrgrain;
}
