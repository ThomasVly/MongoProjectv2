package com.example.demo.controller;

import com.example.demo.object.Commande;
import com.example.demo.object.Materiel;
import com.example.demo.service.CommandeService;
import com.example.demo.service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/materiel")
public class MaterielController {

    private final MaterielService materielService;

    private final CommandeService commandeService;

    @Autowired
    public MaterielController(MaterielService materielService, CommandeService commandeService) {
        this.materielService = materielService;
        this.commandeService = commandeService;
    }

    @PostMapping("/add")
    public Materiel addMateriel(Materiel materiel) {
        return materielService.addMateriel(materiel);
    }

    @GetMapping("/getAll")
    public List<Materiel> getAllMateriel() {
        return materielService.getAllMateriel();
    }

    @GetMapping("/createMateriel")
    public void addMateriel(String num, String marque, String modele, String type, float prix){

        materielService.addMateriel(new Materiel(num,marque,modele,type,prix));
    }
}
