package com.example.demo.controller;


import com.example.demo.object.Commande;
import com.example.demo.object.Groupe;
import com.example.demo.object.Materiel;
import com.example.demo.object.Membre;
import com.example.demo.service.CommandeService;
import com.example.demo.service.MaterielService;
import com.example.demo.service.MembreService;
import com.example.demo.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.MetaMessage;
import javax.swing.*;
import java.util.*;

@RestController
@RequestMapping("/membre")
public class MembreController {
    private final MembreService membreService;
    private final GroupeService groupeService;
    private final MaterielService materielService;
    private final CommandeService commandeService;
    @Autowired
    public MembreController(MembreService membreService, GroupeService groupeService, MaterielService materielService, CommandeService commandeService) {

        this.membreService = membreService;
        this.groupeService = groupeService;
        this.materielService = materielService;
        this.commandeService = commandeService;
    }

    @PostMapping("/create")
    public Membre create(@RequestBody Membre membre) {

        return membreService.createMembre(membre);
    }

    @GetMapping("/addToGroup")
    public void addMembreToGroup(Membre membre, int num){

        Groupe tt = groupeService.getGroupe(num).addMembre(membre);
        groupeService.saveGroupe(tt);

    }
    @PostMapping("/login")
    public Boolean validateLogin(String mail, String pass){

        return membreService.validateLogin(mail, pass);
    }














}
