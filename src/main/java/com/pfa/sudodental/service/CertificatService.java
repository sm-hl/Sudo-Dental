package com.pfa.sudodental.service;

import com.pfa.sudodental.model.Certificat;
import com.pfa.sudodental.repository.CertificatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificatService extends AbstractService<Certificat,Long>{
    @Autowired
    private CertificatRepository certificatRepository;

    @Override
    protected JpaRepository<Certificat,Long> getRepository(){
        return certificatRepository;
    }
}
