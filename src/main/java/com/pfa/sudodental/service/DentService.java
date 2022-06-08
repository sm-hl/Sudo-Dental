package com.pfa.sudodental.service;


import com.pfa.sudodental.model.Dent;
import com.pfa.sudodental.repository.DentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DentService extends AbstractService<Dent,Long>{

    @Autowired
    private DentRepository dentRepository;

    @Override
    protected JpaRepository<Dent, Long> getRepository(){
        return dentRepository;

    }
}