package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.Decrire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecrireRepository extends JpaRepository<Decrire, Long> {
}