package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class VoyagePasse {

    private int idVoyage, idVoyageur, idPays;

    public VoyagePasse(){

    }

    public VoyagePasse(int idVoyage, int idVoyageur, int idPays) {
        this.idVoyage = idVoyage;
        this.idVoyageur = idVoyageur;
        this.idPays = idPays;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public int getIdVoyageur() {
        return idVoyageur;
    }

    public void setIdVoyageur(int idVoyageur) {
        this.idVoyageur = idVoyageur;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }
}
