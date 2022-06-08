package com.pfa.sudodental.service;


import com.pfa.sudodental.model.Patient;
import com.pfa.sudodental.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends AbstractService<Patient,Long>{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    protected JpaRepository<Patient, Long> getRepository(){
        return patientRepository;

    }

}
