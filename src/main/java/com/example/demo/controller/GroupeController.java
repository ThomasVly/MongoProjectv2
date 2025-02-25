package com.example.demo.controller;

import com.example.demo.object.Groupe;
import com.example.demo.object.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CommandeService;
import com.example.demo.service.MaterielService;
import com.example.demo.service.MembreService;
import com.example.demo.service.GroupeService;

import java.util.ArrayList;

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
    public void createGroup(int num, String nom, String ville, int cp, ArrayList<Membre> membres){

        ArrayList<Membre> m = new ArrayList<>();
        groupeService.saveGroupe(new Groupe(num,nom,ville, cp, membres));
    }
}
