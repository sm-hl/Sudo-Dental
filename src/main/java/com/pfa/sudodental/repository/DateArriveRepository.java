package com.pfa.sudodental.repository;

import com.pfa.sudodental.model.DateArrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateArriveRepository extends JpaRepository<DateArrive, Long> {
}