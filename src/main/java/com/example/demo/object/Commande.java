package com.example.demo.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "commandes")
public class Commande {

    @Id
    private String id_commande;
    private Membre membre_client; // L'identifiant unique
    private Membre membre_vendeur;
    private Date date;
    private ArrayList<Materiel> listeMateriel;
    private float prix_total;

    public Commande(String id, Membre mc, Membre mv, Date d, ArrayList<Materiel> materiel, float ttl){

        this.id_commande = id;
        this.membre_client = mc;
        this.membre_vendeur = mv;
        this.date = d;
        this.listeMateriel = materiel;
        this.prix_total = ttl;
    }

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

    public ArrayList<Materiel> getListeMateriel() {
        return listeMateriel;
    }

    public void setListeMateriel(ArrayList<Materiel> listeMateriel) {
        this.listeMateriel = listeMateriel;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }
}
