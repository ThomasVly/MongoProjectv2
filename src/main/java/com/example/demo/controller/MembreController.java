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

    @GetMapping("/createGroup")
    public void createGroup(int num, String nom, String ville, int cp, ArrayList<Membre> membres){

        ArrayList<Membre> m = new ArrayList<>();
        groupeService.saveGroupe(new Groupe(num,nom,ville, cp, membres));
    }

    @GetMapping("/createMateriel")
    public void addMateriel(String num, String marque, String modele, String type, float prix){

        materielService.addMateriel(new Materiel(num,marque,modele,type,prix));
    }

    @GetMapping("/addCommande")
    public void addCommande(String id, Membre client, Membre vendeur, Date date, ArrayList<Materiel> lm, float prix){

        commandeService.saveCommande(new Commande(id,client,vendeur,date,lm,prix));
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
}
