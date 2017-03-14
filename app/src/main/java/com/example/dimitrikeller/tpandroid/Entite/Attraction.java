package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class Attraction {

    private int idAttraction;
    private String nom;
    private String description;
    private String ville;
    private int idPreference;
    private String preference;
    private int ressImgAttraction;

    public Attraction(int idAttraction, String nom, String description, String ville, int idPreference, String preference, int ressImgAttraction) {
        this.idAttraction = idAttraction;
        this.nom = nom;
        this.description = description;
        this.ville = ville;
        this.idPreference = idPreference;
        this.preference = preference;
        this.ressImgAttraction = ressImgAttraction;
    }

    public int getIdAttraction() {
        return idAttraction;
    }

    public void setIdAttraction(int idAttraction) {
        this.idAttraction = idAttraction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public int getRessImgAttraction() {
        return ressImgAttraction;
    }

    public void setRessImgAttraction(int ressImgAttraction) {
        this.ressImgAttraction = ressImgAttraction;
    }
}
