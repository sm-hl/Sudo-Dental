package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Long> {
}