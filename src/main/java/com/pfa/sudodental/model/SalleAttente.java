package com.pfa.sudodental.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalleAttente extends AbstractModel<Long> {
 private String date;
 private String status;
 private String heureArrive;
   @ManyToOne(
           cascade = CascadeType.REFRESH,
           fetch = FetchType.LAZY
   )
   @JoinColumn(name = "patient_id")
   private Patient patient;

}
