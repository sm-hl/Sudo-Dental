package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.Patient;
import com.pfa.sudodental.model.SalleAttente;
import com.pfa.sudodental.service.DateArriveService;
import com.pfa.sudodental.service.PatientService;
import com.pfa.sudodental.service.SalleAttenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalleAttController {
    @Autowired
    MenuController menuController;
    @Autowired
    PatientService patientService;
    @Autowired
    DateArriveService dateArrive;
    @Autowired
    SalleAttenteService salleAttenteService;

    @PostMapping("/addAtt")
    public String add(@ModelAttribute SalleAttente salleAttente, Model model) {
        Patient patient= patientService.get(salleAttente.getPatient().getId());
        salleAttente.setPatient(patient);
        salleAttente.getDateArrive().setDateArive(dateArrive.getDateNow());
        salleAttenteService.save(salleAttente);
        return menuController.listAttente(model);
    }
    @GetMapping("/deleteAtt/{id}")
    public String delete(@PathVariable Long id, Model model){
       salleAttenteService.delete(id);
        return menuController.listAttente(model);
    }
}
