package com.example.demo.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Groupe")
public class Groupe {

    @Id
    private int numero_groupe; // L'identifiant unique
    private String nom;
    private String ville;
    private int code_postal;

    public int getNumero_groupe() {
        return numero_groupe;
    }

    public void setNumero_groupe(int numero_groupe) {
        this.numero_groupe = numero_groupe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
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
}
