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
 private String status;
    @ManyToOne(
            cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "date_arrive")
    private DateArrive dateArrive;

}
