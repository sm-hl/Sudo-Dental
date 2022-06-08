package com.pfa.sudodental.controller;

import com.pfa.sudodental.model.Depense;
import com.pfa.sudodental.service.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepenseController {
    @Autowired
    DepenseService depenseService;

    @PostMapping("/addDepense")
    public String add(@ModelAttribute Depense depense) {
        depense.setEtat(false);
        depenseService.save(depense);
        return "redirect:/Depenses";
    }
    @GetMapping("/deleteDepense/{id}")
    public String delete(@PathVariable Long id){
        depenseService.delete(id);
        return "redirect:/Depenses";
    }
}
