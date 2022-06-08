package com.pfa.sudodental.service;

import com.pfa.sudodental.model.Consultation;
import com.pfa.sudodental.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService extends AbstractService<Consultation,Long>{

@Autowired
private ConsultationRepository consultationRepository;

@Override
protected JpaRepository<Consultation, Long> getRepository(){
        return consultationRepository;

}
}
