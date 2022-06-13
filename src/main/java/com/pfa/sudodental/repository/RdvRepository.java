package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Long> {
    @Query(value = "from Rdv where DateRdv=?1 and Etat=false")
    List<Rdv> getRdvByDate(String date);
}