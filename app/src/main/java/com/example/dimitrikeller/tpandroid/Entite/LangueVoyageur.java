package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class LangueVoyageur {

    private int idVoyageur, idLangue;

    public LangueVoyageur(int idVoyageur, int idLangue) {
        this.idVoyageur = idVoyageur;
        this.idLangue = idLangue;
    }

    public int getIdVoyageur() {
        return idVoyageur;
    }

    public void setIdVoyageur(int idVoyageur) {
        this.idVoyageur = idVoyageur;
    }

    public int getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(int idLangue) {
        this.idLangue = idLangue;
    }
}
