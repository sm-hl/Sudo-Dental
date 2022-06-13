package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.Rdv;
import com.pfa.sudodental.model.SalleAttente;
import com.pfa.sudodental.service.PatientService;
import com.pfa.sudodental.service.RdvService;
import com.pfa.sudodental.service.SalleAttenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RdvController {
    @Autowired
    RdvService rdvService;
    @Autowired
    PatientService patientService;
    @Autowired
    SalleAttenteService salleAttenteService;


    @PostMapping("/validerRdv")
    public String validerRdv(@ModelAttribute SalleAttente salleAttente, Model model){
        //date actuelle
        SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date date=new Date();
        formatter.format(date);
        Rdv rdv=rdvService.get(salleAttente.getPatient().getId());
        rdv.setEtat(true);
        salleAttente.setPatient(rdv.getPatient());
        salleAttente.setDate(formatter.format(date));
        salleAttenteService.save(salleAttente);
        return "redirect:/Rdvs";
    }
}
