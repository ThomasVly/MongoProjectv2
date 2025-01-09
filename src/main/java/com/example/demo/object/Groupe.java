package com.example.demo.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import java.util.ArrayList;

@Document(collection = "groupe")
public class Groupe {

    @Id
    private int numero_groupe; // L'identifiant unique
    private String nom;
    private String ville;
    private int code_postal;
    private ArrayList<Membre> membres;

    public Groupe(int num, String nom, String ville, int cp, ArrayList<Membre> mem){
        this.numero_groupe = num;
        this.nom = nom;
        this.ville = ville;
        this.code_postal = cp;
        this.membres = mem;
    }

    public int getNumero_groupe() {

        return numero_groupe;
    }

    public void setNumero_groupe(int numero_groupe) {

        this.numero_groupe = numero_groupe;
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

    public Groupe addMembre(Membre membre){
        this.membres.add(membre);
        return this;
    }
}
