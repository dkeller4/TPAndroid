package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by mcaron1 on 2017-03-22.
 */

public class Utilisateur {

    private int idVoyageur;
    private String identifiant;
    private String motPasse;

    public Utilisateur() {
    }

    public Utilisateur(int idVoyageur, String identifiant, String motPasse) {
        this.idVoyageur = idVoyageur;
        this.identifiant = identifiant;
        this.motPasse = motPasse;
    }

    public int getIdVoyageur() {
        return idVoyageur;
    }

    public void setIdVoyageur(int idVoyageur) {
        this.idVoyageur = idVoyageur;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
}
