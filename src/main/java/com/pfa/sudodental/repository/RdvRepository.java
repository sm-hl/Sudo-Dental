package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Long> {
    @Query(value = "from Rdv where DateRdv=?1 and Etat=false")
    List<Rdv> getFRdvByDate(String date);

    @Query(value = "from Rdv where DateRdv=?1 and Etat=true ")
    List<Rdv> getTRdvByDate(String date);


    @Query(value = "from Rdv where Etat=false")
    List<Rdv> getAllNonValid();

    @Query(value = "from Rdv where Etat=true")
    List<Rdv> getAllValid();
}