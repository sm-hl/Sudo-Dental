package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.Ordonance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdonanceRepository extends JpaRepository<Ordonance, Long> {
}