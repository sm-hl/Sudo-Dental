package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.SalleAttente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleAttenteRepository extends JpaRepository<SalleAttente, Long> {
}