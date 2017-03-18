package com.example.dimitrikeller.tpandroid.Entite;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class Pays {

    private int idPays;
    private String nom;
    private int population;
    private String continent;
    private String capitale;
    private String devise;
    private int ressImgDrapeau;
    private int ressImgPays;
    private ArrayList<LanguePays> listeLanguePays;
    private ArrayList<PreferencePays> listePreferencePays;
    private ArrayList<AttractionPays> listeAttractionPays;


    public Pays(){

    }

    public Pays(int idPays, String nom, int population, String continent, String capitale, String devise, int ressImgDrapeau, int ressImgPays, ArrayList<LanguePays> listeLanguePays, ArrayList<PreferencePays> listePreferencePays, ArrayList<AttractionPays> listeAttractionPays) {
        this.idPays = idPays;
        this.nom = nom;
        this.population = population;
        this.continent = continent;
        this.capitale = capitale;
        this.devise=devise;
        this.ressImgDrapeau = ressImgDrapeau;
        this.ressImgPays = ressImgPays;
        this.listeLanguePays = listeLanguePays;
        this.listePreferencePays = listePreferencePays;
        this.listeAttractionPays = listeAttractionPays;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getCapitale() {
        return capitale;
    }

    public void setCapitale(String capitale) {
        this.capitale = capitale;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getRessImgDrapeau() {
        return ressImgDrapeau;
    }

    public void setRessImgDrapeau(int ressImgDrapeau) {
        this.ressImgDrapeau = ressImgDrapeau;
    }

    public int getRessImgPays() {
        return ressImgPays;
    }

    public void setRessImgPays(int ressImgPays) {
        this.ressImgPays = ressImgPays;
    }

    public ArrayList<LanguePays> getListeLanguePays() {
        return listeLanguePays;
    }

    public void setListeLanguePays(ArrayList<LanguePays> listeLanguePays) {
        this.listeLanguePays = listeLanguePays;
    }

    public ArrayList<PreferencePays> getListePreferencePays() {
        return listePreferencePays;
    }

    public void setListePreferencePays(ArrayList<PreferencePays> listePreferencePays) {
        this.listePreferencePays = listePreferencePays;
    }

    public ArrayList<AttractionPays> getListeAttractionPays() {
        return listeAttractionPays;
    }

    public void setListeAttractionPays(ArrayList<AttractionPays> listeAttractionPays) {
        this.listeAttractionPays = listeAttractionPays;
    }


}
