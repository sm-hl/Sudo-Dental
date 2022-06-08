package com.pfa.sudodental.service;


import com.pfa.sudodental.model.DossierMedicale;
import com.pfa.sudodental.repository.DossierMedicaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DossierMedicaleService extends AbstractService<DossierMedicale,Long>{

    @Autowired
    private DossierMedicaleRepository dossierMedicaleRepository;

    @Override
    protected JpaRepository<DossierMedicale,Long> getRepository(){
        return dossierMedicaleRepository;

    }
}
