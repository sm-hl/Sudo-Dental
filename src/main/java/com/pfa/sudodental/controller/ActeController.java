package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.Acte;
import com.pfa.sudodental.model.DossierMedicale;
import com.pfa.sudodental.model.Patient;
import com.pfa.sudodental.service.ActeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActeController {
    @Autowired
    ActeService acteService;
    @Autowired
    MenuController menuController;

    @PreAuthorize("hasAuthority('MED')")
    @PostMapping("/addActe")
    public String add(@ModelAttribute Acte acte, Model model) {
        acteService.save(acte);
        return "redirect:/Actes";
    }
    @PreAuthorize("hasAuthority('MED')")
    @GetMapping("/deleteActe/{id}")
    public String delete(@PathVariable Long id, Model model){
        acteService.delete(id);
        return "redirect:/Actes";
    }
}
