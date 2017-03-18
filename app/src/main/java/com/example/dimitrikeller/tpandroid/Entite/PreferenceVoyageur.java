package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class PreferenceVoyageur {

    private int idVoyageur, idPreference;

    public PreferenceVoyageur(){

    }

    public PreferenceVoyageur(int idVoyageur, int idPreference) {
        this.idVoyageur = idVoyageur;
        this.idPreference = idPreference;
    }

    public int getIdVoyageur() {
        return idVoyageur;
    }

    public void setIdVoyageur(int idVoyageur) {
        this.idVoyageur = idVoyageur;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }
}
