package com.pfa.sudodental.service;

import com.pfa.sudodental.model.SalleAttente;
import com.pfa.sudodental.repository.SalleAttenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleAttenteService extends AbstractService<SalleAttente,Long> {
    @Autowired
    private SalleAttenteRepository salleAttenteRepository;

    @Override
    protected JpaRepository<SalleAttente, Long> getRepository(){
        return salleAttenteRepository;
    }

    public List<SalleAttente> getByDate(String date){
        return salleAttenteRepository.getByDate(date);
    }

}
