package com.example.demo.controller;

import com.example.demo.object.Commande;
import com.example.demo.object.Materiel;
import com.example.demo.object.Membre;
import com.example.demo.service.CommandeService;
import com.example.demo.service.GroupeService;
import com.example.demo.service.MaterielService;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CommandeService;
import com.example.demo.service.MaterielService;
import com.example.demo.service.MembreService;
import com.example.demo.service.GroupeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final MembreService membreService;
    private final GroupeService groupeService;
    private final MaterielService materielService;
    private final CommandeService commandeService;
    @Autowired
    public CommandeController(MembreService membreService, GroupeService groupeService, MaterielService materielService, CommandeService commandeService) {

        this.membreService = membreService;
        this.groupeService = groupeService;
        this.materielService = materielService;
        this.commandeService = commandeService;
    }

    @PostMapping("/getByMateriel")
    public List<Commande> getByMateriel(String numserie){

        List<Commande> a = commandeService.getAllCommandes();
        List<Commande> b = new ArrayList<>(Collections.emptyList());

        for (Commande c : a){
            for (Materiel e : c.getListeMateriel())
                if (e.getNumero_serie() == numserie && !b.contains(c)){
                    b.add(c);
                }
        }

        return b;
    }

    @PostMapping("/getByActif")
    public List<Commande> getByActif(String nom){

        List<Commande> a = commandeService.getAllCommandes();
        List<Commande> b = new ArrayList<>(Collections.emptyList());

        for (Commande c : a){
            if (c.getMembre_vendeur().equals(nom)){
                b.add(c);
            }
        }

        return b;
    }

    @PostMapping("/getByClient")
    public List<Commande> getByClient(String nom){

        List<Commande> a = commandeService.getAllCommandes();
        List<Commande> b = new ArrayList<>(Collections.emptyList());

        for (Commande c : a){
            if (c.getMembre_client().equals(nom)){
                b.add(c);
            }
        }

        return b;
    }
    @PostMapping("/getByDate")
    public List<Commande> getByDate(Date sd, Date ed){

        List<Commande> a = commandeService.getAllCommandes();
        List<Commande> b = new ArrayList<>(Collections.emptyList());

        for (Commande c : a){
            if (c.getDate().after(sd) && c.getDate().before(ed) ){
                b.add(c);
            }
        }

        return b;
    }

    @GetMapping("/addCommande")
    public void addCommande(String id, Membre client, Membre vendeur, Date date, ArrayList<Materiel> lm, float prix){

        commandeService.saveCommande(new Commande(id,client,vendeur,date,lm,prix));
    }

}
