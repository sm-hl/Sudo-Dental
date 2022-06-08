package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.DossierMedicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicaleRepository extends JpaRepository<DossierMedicale, Long> {
}