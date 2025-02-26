package com.example.demo.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import java.util.ArrayList;

@Document(collection = "groupe")
public class Groupe {

    @Id
    private String numeroGroupe; // L'identifiant unique
    private String nom;
    private String ville;
    private int code_postal;
    private ArrayList<Membre> membres;
    private ArrayList<Materiel> materiels;

    public Groupe(String numeroGroupe, String nom, String ville, int code_postal, ArrayList<Membre> membres, ArrayList<Materiel> materiels) {
        this.numeroGroupe = numeroGroupe;
        this.nom = nom;
        this.ville = ville;
        this.code_postal = code_postal;
        this.membres = membres;
        this.materiels = materiels;
    }

    public String getNumeroGroupe() {

        return numeroGroupe;
    }

    public void setNumeroGroupe(String numeroGroupe) {

        this.numeroGroupe = numeroGroupe;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom){
            this.nom = nom;
    }

    public String getVille() {

        return ville;
    }

    public void setVille(String ville) {

        this.ville = ville;
    }

    public int getCode_postal() {

        return code_postal;
    }

    public void setCode_postal(int code_postal) {

        this.code_postal = code_postal;
    }


    public ArrayList<Membre> getMembres() {
        return membres;
    }

    public void setMembres(ArrayList<Membre> membres) {
        this.membres = membres;
    }

    public Groupe addMaterial(Materiel materiel){
        this.materiels.add(materiel);
        return this;
    }

    public ArrayList<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriel(ArrayList<Materiel> materiels) {
        this.materiels = materiels;
    }

    public Groupe addMembre(Membre membre){
        this.membres.add(membre);
        return this;
    }
}
