package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class CompagnonVoyageFutur {

    private int idVoyageFutur, idVoyageurCompagnon;

    public CompagnonVoyageFutur(int idVoyageFutur, int idVoyageurCompagnon) {
        this.idVoyageFutur = idVoyageFutur;
        this.idVoyageurCompagnon = idVoyageurCompagnon;
    }

    public int getIdVoyageFutur() {
        return idVoyageFutur;
    }

    public void setIdVoyageFutur(int idVoyageFutur) {
        this.idVoyageFutur = idVoyageFutur;
    }

    public int getIdVoyageurCompagnon() {
        return idVoyageurCompagnon;
    }

    public void setIdVoyageurCompagnon(int idVoyageurCompagnon) {
        this.idVoyageurCompagnon = idVoyageurCompagnon;
    }
}
