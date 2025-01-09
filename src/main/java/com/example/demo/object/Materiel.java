package com.example.demo.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "materiel")
public class Materiel {

    @Id
    private String numero_serie; // L'identifiant unique
    private String marque;
    private String modele;
    private String type;
    private float prix;

    public Materiel(String num, String mar, String mod, String type, float prix){
        this.numero_serie = num;
        this.marque = mar;
        this.modele = mod;
        this.type = type;
        this.prix = prix;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
