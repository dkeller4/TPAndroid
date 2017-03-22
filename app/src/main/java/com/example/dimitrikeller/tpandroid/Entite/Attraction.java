package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class Attraction {

    private int idAttraction;
    private String nom;
    private String description;
    private String duree;
    private String ville;
    private String telephone;
    private String web;
    private String gratuit;
    private String ressImgAttraction;

    public Attraction(){

    }

    public Attraction(int idAttraction, String nom, String description, String duree, String ville, String telephone, String web, String gratuit, String ressImgAttraction) {
        this.idAttraction = idAttraction;
        this.nom = nom;
        this.description = description;
        this.duree = duree;
        this.ville = ville;
        this.telephone = telephone;
        this.web = web;
        this.gratuit = gratuit;
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

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getGratuit() {
        return gratuit;
    }

    public void setGratuit(String gratuit) {
        this.gratuit = gratuit;
    }

    public String getRessImgAttraction() {
        return ressImgAttraction;
    }

    public void setRessImgAttraction(String ressImgAttraction) {
        this.ressImgAttraction = ressImgAttraction;
    }
}
