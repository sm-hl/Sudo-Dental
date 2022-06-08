package com.pfa.sudodental.service;

import com.pfa.sudodental.model.Seance;
import com.pfa.sudodental.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SeanceService extends AbstractService<Seance,Long>{

    @Autowired
    private SeanceRepository scianceRepository;

    @Override
    protected JpaRepository<Seance, Long> getRepository(){
        return scianceRepository;

    }
}
