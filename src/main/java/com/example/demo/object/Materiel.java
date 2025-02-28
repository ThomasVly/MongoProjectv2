package com.example.demo.object;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "materiel")
public class Materiel {
    private String numero_serie;
    private String marque;
    private String modele;
    private String type;
    private float prix;

    // Getters et Setters

    public Materiel(String numero_serie, String marque, String modele, String type, float prix) {
        this.numero_serie = numero_serie;
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.prix = prix;
    }


    public Materiel() {
        // Constructeur sans argument requis par Spring
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

    public String toString() {
        return "Materiel{" +
                "numero_serie='" + numero_serie + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                '}';
    }
}
