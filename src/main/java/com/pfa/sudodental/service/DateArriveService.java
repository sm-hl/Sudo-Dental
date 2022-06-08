package com.pfa.sudodental.service;

import com.pfa.sudodental.model.DateArrive;
import com.pfa.sudodental.repository.DateArriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class DateArriveService extends AbstractService<DateArrive,Long>{

    @Autowired
    private DateArriveRepository dateArriveRepository;

    @Override
    protected JpaRepository<DateArrive, Long> getRepository(){
        return dateArriveRepository;

    }
    public String getDateNow(){
        LocalDateTime now = LocalDateTime.now();
        return Date.from(now.atZone(ZoneId.systemDefault()).toInstant()).toString();
    }
}