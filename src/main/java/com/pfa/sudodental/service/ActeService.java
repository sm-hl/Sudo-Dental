package com.pfa.sudodental.service;

import com.pfa.sudodental.model.Acte;
import com.pfa.sudodental.repository.ActeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActeService extends AbstractService<Acte,Long>{
    @Autowired
    private ActeRepository acteRepository;

    @Override
    protected JpaRepository<Acte, Long> getRepository(){
        return acteRepository;
    }

    public Acte getActeByNom(String noma){
        return acteRepository.findActeByNomA(noma);
    }

}
