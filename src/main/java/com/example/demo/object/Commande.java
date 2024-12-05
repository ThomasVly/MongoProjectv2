package com.example.demo.object;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;

public class Commande {

    @Id
    private String id_commande;
    private Membre membre_client; // L'identifiant unique
    private Membre membre_vendeur;
    private Date date;
    private ArrayList<Materiel> liste_materiel;
    private float prix_total;

    public String getId_commande() {
        return id_commande;
    }

    public void setId_commande(String id_commande) {
        this.id_commande = id_commande;
    }

    public Membre getMembre_client() {
        return membre_client;
    }

    public void setMembre_client(Membre membre_client) {
        this.membre_client = membre_client;
    }

    public Membre getMembre_vendeur() {
        return membre_vendeur;
    }

    public void setMembre_vendeur(Membre membre_vendeur) {
        this.membre_vendeur = membre_vendeur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Materiel> getListe_materiel() {
        return liste_materiel;
    }

    public void setListe_materiel(ArrayList<Materiel> liste_materiel) {
        this.liste_materiel = liste_materiel;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }
}
