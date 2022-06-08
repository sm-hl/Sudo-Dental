package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.Acte;
import com.pfa.sudodental.model.Medicament;
import com.pfa.sudodental.service.ActeService;
import com.pfa.sudodental.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicamentController {
    @Autowired
    MedicamentService medicamentService;
    @Autowired
    MenuController menuController;

    @PostMapping("/addMedicament")
    public String add(@ModelAttribute Medicament medicament, Model model) {
        medicamentService.save(medicament);
        return "redirect:/Medicaments";
    }
    @GetMapping("/deleteMedicament/{id}")
    public String delete(@PathVariable Long id, Model model){
        medicamentService.delete(id);
        return "redirect:/Medicaments";
    }
}
