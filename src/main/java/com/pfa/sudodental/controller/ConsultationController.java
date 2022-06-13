package com.pfa.sudodental.controller;

import com.lowagie.text.DocumentException;
import com.pfa.sudodental.DTO.OrdonanceDTO;
import com.pfa.sudodental.export.CertificatExport;
import com.pfa.sudodental.export.OrdonanceExport;
import com.pfa.sudodental.model.*;
import com.pfa.sudodental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ConsultationController {

    @Autowired
    ConsultationService consultationService;
    @Autowired
    MedicamentService medicamentService;
    @Autowired
    OrdonanceService ordonanceService;
    @Autowired
    PatientService patientService;
    @Autowired
    SeanceService seanceService;
    @Autowired
    CertificatService certificatService;


    @GetMapping("/Patient/{id}/consultation/{id2}")
    public String afficheConsultation(@PathVariable(name = "id")Long id, @PathVariable("id2") Long id2, Model model){
        Consultation consultation=consultationService.get(id2);
        List<Medicament> medicamentList=medicamentService.getAll();
        Patient patient=patientService.get(id);
        model.addAttribute("certificatobject",new Certificat());
        model.addAttribute("ordonanceDTO",new OrdonanceDTO());
        model.addAttribute("patient",patient);
        model.addAttribute("seanceobject",new Seance());
        model.addAttribute("consultation",consultation);
        model.addAttribute("medicaments",medicamentList);
        return "Gestion/Consultation";
    }
    @PostMapping("/Patient/{id}/consultation/{id2}/addseance")
    public String ajouterSeance(@ModelAttribute Seance seance, @PathVariable(name = "id")Long id, @PathVariable("id2") Long id2, Model model){
       //avoid problem
        seance.setId(null);
        Reglement reglement=new Reglement();
        seance.setReglement(reglement);
        seanceService.save(seance);
         Consultation consultation=consultationService.get(id2);
         consultation.getSeanceList().add(seance);
         consultationService.save(consultation);
        return "redirect:/Patient/"+id+"/consultation/"+id2;
    }
    @GetMapping("/Patient/{id}/consultation/{id2}/deleteseance/{ids}")
    public String deleteSeance(@PathVariable(name = "ids") Long ids, @PathVariable(name = "id")Long id, @PathVariable("id2") Long id2, Model model) {
        Seance seance = seanceService.get(ids);
        Consultation consultation = consultationService.get(id2);
        consultation.getSeanceList().remove(seance);
        consultationService.save(consultation);
        return "redirect:/Patient/" + id + "/consultation/" + id2;
    }
    @PostMapping("/Patient/{id}/consultation/{id2}/addordonance")
    public String ajouterOrdonance(@ModelAttribute OrdonanceDTO ordonanceDTO, @PathVariable(name = "id")Long id, @PathVariable("id2") Long id2){
        Ordonance ordonance=ordonanceService.dtoToModel(ordonanceDTO);
        Consultation consultation=consultationService.get(id2);
        consultation.getOrdonanceList().add(ordonance);
        consultationService.save(consultation);
        return "redirect:/Patient/"+id+"/consultation/"+id2;
    }
    @PostMapping("/Patient/{id}/consultation/{id2}/addcertificat")
    public String ajouterCertificat(@ModelAttribute Certificat certificat, @PathVariable(name = "id")Long id, @PathVariable("id2") Long id2){
        certificat.setId(null);
        Consultation consultation=consultationService.get(id2);
        consultation.getCertificatSet().add(certificat);
        consultationService.save(consultation);
        return "redirect:/Patient/"+id+"/consultation/"+id2;
    }
    @GetMapping("/Patient/{id}/consultation/{id2}/deletecertificat/{idc}")
    public String deleteCertificat(@PathVariable(name = "idc") Long idc, @PathVariable(name = "id")Long id, @PathVariable("id2") Long id2, Model model) {
        Certificat certificat = certificatService.get(idc);
        Consultation consultation = consultationService.get(id2);
        consultation.getCertificatSet().remove(certificat);
        consultationService.save(consultation);
        return "redirect:/Patient/" + id + "/consultation/" + id2;
    }
    @GetMapping("/Patient/{id}/consultation/{id2}/validerReglement/{ids}")
    public String validerReglement(@PathVariable(name = "id")Long id, @PathVariable("id2") Long id2,@PathVariable(name = "ids") Long ids){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date=new Date();
        Consultation consultation=consultationService.get(id2);
         Seance seance=seanceService.get(ids);
         seance.getReglement().setMontantPaye(seance.getMontantSc());
         seance.getReglement().setDatePayment(formatter.format(date));
         seance.getReglement().setFlux("entrant");
         seanceService.save(seance);
        return "redirect:/Patient/"+id+"/consultation/"+id2;
    }
    @GetMapping("/Patient/{id}/consultation/{id2}/exportOrdonance/{id3}")
    public String exportOToPDF( @PathVariable(name = "id")Long id, @PathVariable("id2") Long id2,@PathVariable("id3") Long id3, HttpServletResponse response) throws DocumentException, IOException {
        Ordonance ordonance=ordonanceService.get(id3);
        Patient patient=patientService.get(id);
        OrdonanceExport ordonanceExport=new OrdonanceExport(ordonance,patient);
        ordonanceExport.writeData(response);

        response.setContentType("application/pdf");
        String headerKey = "filename";
        String headerValue = "attachment; filename=ordonance"+".pdf";
        response.setHeader(headerKey, headerValue);

        return "redirect:/Patient/"+id+"/consultation/"+id2;
    }
    @GetMapping("/Patient/{id}/consultation/{id2}/exportCertificat/{id3}")
    public String exportCToPDF( @PathVariable(name = "id")Long id, @PathVariable("id2") Long id2,@PathVariable("id3") Long id3, HttpServletResponse response) throws DocumentException, IOException {
        Certificat certificat=certificatService.get(id3);
        Patient patient=patientService.get(id);
        CertificatExport certificatExport=new CertificatExport(certificat,patient);
        certificatExport.writeData(response);

        response.setContentType("application/pdf");
        String headerKey = "filename";
        String headerValue = "attachment; filename=Certificat"+".pdf";
        response.setHeader(headerKey, headerValue);

        return "redirect:/Patient/"+id+"/consultation/"+id2;
    }
}

