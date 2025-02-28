package com.example.demo.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="membre")
public class Membre {

    @Id
    private String id_membre; // L'identifiant unique

    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String type_membre;
    private String password;

    public Membre(String id_membre, String nom, String prenom, String adresse, String email, String type_membre, String password){
        this.id_membre = id_membre;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.type_membre = type_membre;
        this.password = password;
    }

    public String getId_membre() {
        return id_membre;
    }

    public void setId_membre(String id_membre) {
        this.id_membre = id_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType_membre() {
        return type_membre;
    }

    public void setType_membre(String type_membre) {
        this.type_membre = type_membre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
