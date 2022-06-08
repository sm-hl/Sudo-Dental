package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.*;
import com.pfa.sudodental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    PatientService patientService;
    @Autowired
    ActeService acteService;
    @Autowired
    MedicamentService medicamentService;
    @Autowired
    RdvService rdvService;
    @Autowired
    SalleAttenteService salleAttenteService;
    @Autowired
    DepenseService depenseService;
    @Autowired
    ReglementService reglementService;

    @RequestMapping("/Patients")
    public String listPatient(Model model){
        List<Patient> patients=patientService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("patientobject",new Patient());
        return "Gestion/Patient";
    }
    @RequestMapping("/Actes")
    public String listActe(Model model){
        List<Acte> actes=acteService.getAll();
        model.addAttribute("actes",actes);
        model.addAttribute("acteobject",new Acte());
        return "Gestion/Gacte";
    }
    @RequestMapping("/Medicaments")
    public String listMedicament(Model model){
        List<Medicament> medicaments=medicamentService.getAll();
        model.addAttribute("medicaments",medicaments);
        model.addAttribute("medicamentobject",new Medicament());
        return "Gestion/Gmedicament";
    }
    @RequestMapping("/Rdvs")
    public String listRdv(Model model){
        List<Rdv> rdvs=rdvService.getAll();
        model.addAttribute("rdvs",rdvs);
        return "Gestion/Rdv";
    }
    @RequestMapping("/Attente")
    public String listAttente(Model model){
        List<Patient> patients=patientService.getAll();
        List<SalleAttente> salleAttentes=salleAttenteService.getAll();
        Patient patient=new Patient();
        DateArrive dateArrive=new DateArrive();
        SalleAttente salleAttente=new SalleAttente();
        salleAttente.setPatient(patient);
        salleAttente.setDateArrive(dateArrive);
        model.addAttribute("salleAttentes",salleAttentes);
        model.addAttribute("salleAttobject",salleAttente);
        model.addAttribute("patients",patients);
        return "Gestion/Attente";
    }
    @RequestMapping("/Depenses")
    public String listDepense(Model model){
    List<Depense> depenses=depenseService.getAll();
    model.addAttribute("depenseObject",new Depense());
    model.addAttribute("depenses",depenses);
    return "Gestion/GDepense";
    }
    @RequestMapping("/Tresorier")
    public String tresorier(Model model){
        List<Depense> depenses=depenseService.getAll();
        List<Reglement> reglements=reglementService.getAll();
        model.addAttribute("reglements",reglements);
        model.addAttribute("depenses",depenses);
        return "Gestion/Tresorier";
    }

}
