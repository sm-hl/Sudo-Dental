package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.Dent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentRepository extends JpaRepository<Dent, Long> {
}