package com.pfa.sudodental.dto;


import lombok.Data;

@Data
public class RdvDTO {
    private String dateRdv;
    private String heureRdv;
    private String heureFin;
    private String traitement;
    private String id;
   private String  nomPatient;
}
