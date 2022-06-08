package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Long> {
}