package com.example.demo.controller;

import com.example.demo.object.Groupe;
import com.example.demo.object.Materiel;
import com.example.demo.object.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.CommandeService;
import com.example.demo.service.MaterielService;
import com.example.demo.service.MembreService;
import com.example.demo.service.GroupeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groupe")
public class GroupeController {

    private final MembreService membreService;
    private final GroupeService groupeService;
    private final MaterielService materielService;
    private final CommandeService commandeService;
    @Autowired
    public GroupeController(MembreService membreService, GroupeService groupeService, MaterielService materielService, CommandeService commandeService) {

        this.membreService = membreService;
        this.groupeService = groupeService;
        this.materielService = materielService;
        this.commandeService = commandeService;
    }

    @GetMapping("/createGroup")
    public void createGroup(String num, String nom, String ville, int cp, ArrayList<Membre> membres, ArrayList<Materiel> materiel){

        ArrayList<Membre> m = new ArrayList<>();
        groupeService.saveGroupe(new Groupe(num,nom,ville, cp, membres, materiel));
    }

    @GetMapping("/getAll")
    public List<Groupe> GetAllGroup(){

        return groupeService.getAllGroupes();
    }

    @PutMapping("/update/{numeroGroupe}")
    public Groupe updateGroupe(@PathVariable String numeroGroupe, @RequestBody Groupe groupeDetails) {
        // Récupérer le groupe existant
        Groupe groupe = groupeService.getGroupe(numeroGroupe);

        // Si le groupe n'existe pas
        if (groupe == null) {
            throw new RuntimeException("Groupe non trouvé avec le numéro: " + numeroGroupe);
        }

        // Mettre à jour les propriétés
        groupe.setNom(groupeDetails.getNom());
        groupe.setVille(groupeDetails.getVille());
        groupe.setCode_postal(groupeDetails.getCode_postal());

        // Sauvegarder le groupe mis à jour
        return groupeService.saveGroupe(groupe);
    }
}
