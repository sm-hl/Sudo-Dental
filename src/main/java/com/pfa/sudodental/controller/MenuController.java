package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.*;
import com.pfa.sudodental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @RequestMapping("/Dashboard")
    public String Dashboard(Model model){
        //date now
        Date date=new Date();
        //agenda
        List<Rdv> rdvsno =rdvService.getAllNonValid();
        model.addAttribute("rdvsno",rdvService.toDTO(rdvsno));
        List<Rdv> rdvsoui =rdvService.getAllValid();
        model.addAttribute("rdvsoui",rdvService.toDTO(rdvsoui));
        //rdv today
        SimpleDateFormat formatter_1=new SimpleDateFormat("E, dd MMM yyyy");
        model.addAttribute("dateNow",  formatter_1.format(date));
        //box
         model.addAttribute("rdvreste",rdvService.rdvReste());
         model.addAttribute("rdvpasse",rdvService.rdvpasse());
         model.addAttribute("VA",reglementService.totalVA());
         //chartpatient
        model.addAttribute("chartAge",patientService.chartAge());
        model.addAttribute("chartSex",patientService.chartSex());
        //situation financier
        SimpleDateFormat formatter_2=new SimpleDateFormat("yyyy");
        String year=formatter_2.format(date);
        model.addAttribute("thisYear",  year+"-"+(Integer.parseInt(year)+1));
        model.addAttribute("chartDepense",reglementService.chartDepense(year));
        model.addAttribute("chartRecette",reglementService.chartRecette(year));
        return "dashboard/index";
    }

    @RequestMapping("/Patients")
    public String listPatient(Model model){
        List<Patient> patients=patientService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("patientobject",new Patient());
        return "Gestion/Patient";
    }
    @PreAuthorize("hasAuthority('MED')")
    @RequestMapping("/Actes")
    public String listActe(Model model){
        List<Acte> actes=acteService.getAll();
        model.addAttribute("actes",actes);
        model.addAttribute("acteobject",new Acte());
        return "Gestion/Gacte";
    }
    @PreAuthorize("hasAuthority('MED')")
    @RequestMapping("/Medicaments")
    public String listMedicament(Model model){
        List<Medicament> medicaments=medicamentService.getAll();
        model.addAttribute("medicaments",medicaments);
        model.addAttribute("medicamentobject",new Medicament());
        return "Gestion/Gmedicament";
    }
    @RequestMapping("/Rdvs")
    public String listRdv(Model model){
        Date date=new Date();
        SimpleDateFormat formatter_1=new SimpleDateFormat("E, dd MMM yyyy");
        model.addAttribute("dateNow",  formatter_1.format(date));
        SimpleDateFormat formatter_2=new SimpleDateFormat("MM/dd/yyyy");
        List<Rdv> rdvs=rdvService.getFRdvByDate(formatter_2.format(date));
        model.addAttribute("rdvs",rdvs);
        model.addAttribute("salleAttobject",new SalleAttente());
        return "Gestion/Rdv";
    }
    @RequestMapping("/Attente")
    public String listAttente(Model model){
        SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        Date date=new Date();
        List<SalleAttente> salleAttentes=salleAttenteService.getByDate(formatter.format(date));
        model.addAttribute("salleAttentes",salleAttentes);
        model.addAttribute("salleAttobject",new SalleAttente());
        return "Gestion/Attente";
    }
    @PreAuthorize("hasAuthority('MED')")
    @RequestMapping("/Depenses")
    public String listDepense(Model model){
    List<Depense> depenses=depenseService.getAll();
    model.addAttribute("depenseObject",new Depense());
    model.addAttribute("depenses",depenses);
    return "Gestion/GDepense";
    }
    @PreAuthorize("hasAuthority('MED')")
    @RequestMapping("/Tresorier")
    public String tresorier(Model model){
        List<Reglement> depenses=reglementService.getAllDPaye();
        List<Reglement> recettes=reglementService.getAllRPaye();
        model.addAttribute("recettes",recettes);
        model.addAttribute("depenses",depenses);
        return "Gestion/Tresorier";
    }

}
