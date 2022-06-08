package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.DossierMedicale;
import com.pfa.sudodental.model.Patient;
import com.pfa.sudodental.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
@Autowired
PatientService patientService;
@Autowired
MenuController menuController;

    @PostMapping("/addPatient")
    public String add(@ModelAttribute Patient patientobject,Model model) {
        DossierMedicale dossierMedicale=new DossierMedicale();
        patientobject.setDossierMedicale(dossierMedicale);
        patientService.save(patientobject);
        return menuController.listPatient(model);
    }
    @GetMapping("/deletePatient/{id}")
    public String delete(@PathVariable Long id,Model model){
        patientService.delete(id);
        return menuController.listPatient(model);
    }
}
