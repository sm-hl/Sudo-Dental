package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.*;
import com.pfa.sudodental.service.ActeService;
import com.pfa.sudodental.service.ConsultationService;
import com.pfa.sudodental.service.PatientService;
import com.pfa.sudodental.service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FichPatientController {
     @Autowired
     PatientService patientService;
     @Autowired
     ConsultationService consultationService;
     @Autowired
     RdvService rdvService;
     @Autowired
     ActeService acteService;

     @GetMapping("/Patient/{id}")
    public String fichPatient(@PathVariable Long id,Model model){
        Patient patient =patientService.get(id);
        patientService.calculAllMontant(patient);
         model.addAttribute("patient",patient);
        patientService.save(patient);
         List<Acte> acteList=acteService.getAll();
        Acte acte=new Acte();
        Consultation consultation=new Consultation();
        consultation.setActe(acte);
        model.addAttribute("consultationObject",consultation);
        model.addAttribute("rdvObject",new Rdv());
        model.addAttribute("dentobject",new Dent());
        model.addAttribute("actes",acteList);
         return "Gestion/fichePatient";
     }
    @PostMapping("/Patient/{id}/EditDM")
    public String EditDossierMedicale(@ModelAttribute Patient patient,Model model,@PathVariable Long id){
        patientService.save(patient);
        return "redirect:/Patient/"+id;
    }

    @PostMapping("/Patient/{id}/addRdv")
    public String AddRdv(@ModelAttribute Rdv rdv,@PathVariable Long id,Model model){
   Patient patient=patientService.get(id);
   //avoid problem
   rdv.setId(null);
   rdv.setEtat(false);
   rdvService.save(rdv);
   patient.getRdvSet().add(rdv);
   patientService.save(patient);
   rdv.setPatient(patient);
   rdvService.save(rdv);
   return "redirect:/Patient/"+id;
    }
    @GetMapping("/Patient/{id}/deleteRdv/{idRdv}")
    public String DeleteRdv(@PathVariable(name = "idRdv") Long idRdv,@PathVariable(name = "id") Long id ,Model model){
        Patient patient=patientService.get(id);
        Rdv rdv=rdvService.get(idRdv);
        patient.getRdvSet().remove(rdv);
        patientService.save(patient);
        rdvService.delete(idRdv);
        return "redirect:/Patient/"+id;
    }
    @PostMapping("/Patient/{id}/addConsultation")
    public String AddConsultation(@ModelAttribute Consultation consultation,@PathVariable Long id,Model model){
        Patient patient=patientService.get(id);
        Acte acte=acteService.getActeByNom(consultation.getActe().getNomA());
        consultation.setActe(acte);
        consultation.setEtatReglement(false);
        patient.getConsultationSet().add(consultation);
        patientService.save(patient);
        return "redirect:/Patient/"+id;
    }
    @GetMapping("/Patient/{id}/deleteConsultation/{idC}")
    public String DeleteConsultation(@PathVariable(name = "idC") Long idC,@PathVariable(name = "id") Long id,Model model){
        Patient patient=patientService.get(id);
        Consultation consultation=consultationService.get(idC);
        patient.getConsultationSet().remove(consultation);
        patientService.save(patient);
        return "redirect:/Patient/"+id;
    }

    @PostMapping("/Patient/{id}/validerSD")
    public String validerSD(@ModelAttribute Dent dent,@PathVariable Long id, Model model){
         //avoid problem
        dent.setId(null);
        Patient patient=patientService.get(id);
  if (!patient.modifierDent(dent)){
            patient.getDentList().add(dent);
        }
        patientService.save(patient);
        return "redirect:/Patient/"+id;
    }

}
