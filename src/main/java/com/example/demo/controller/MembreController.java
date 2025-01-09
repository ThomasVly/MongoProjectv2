package com.example.demo.controller;


import com.example.demo.object.Groupe;
import com.example.demo.object.Membre;
import com.example.demo.service.MembreService;
import com.example.demo.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/membre")
public class MembreController {
    private final MembreService membreService;
    private final GroupeService groupeService;
    @Autowired
    public MembreController(MembreService membreService, GroupeService groupeService) {

        this.membreService = membreService;
        this.groupeService = groupeService;
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

    @GetMapping("/createGroup")
    public void createGroup(int num, String nom, String ville, int cp, ArrayList<Membre> membres){

        ArrayList<Membre> m = new ArrayList<>();
        groupeService.saveGroupe(new Groupe(num,nom,ville, cp, membres));
    }
}
