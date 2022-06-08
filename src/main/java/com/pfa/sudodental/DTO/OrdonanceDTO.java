package com.pfa.sudodental.DTO;

import com.pfa.sudodental.model.Ordonance;
import lombok.Data;

import java.util.List;


@Data
public class OrdonanceDTO {
    Ordonance ordonance;
   List<MedicamentDTO> medicamentDTOList;
}
