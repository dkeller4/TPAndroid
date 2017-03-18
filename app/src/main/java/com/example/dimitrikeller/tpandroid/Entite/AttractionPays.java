package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class AttractionPays {

    private int idPays, idAttraction;

    public  AttractionPays(){

    }

    public AttractionPays(int idPays, int idAttraction) {
        this.idPays = idPays;
        this.idAttraction = idAttraction;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getIdAttraction() {
        return idAttraction;
    }

    public void setIdAttraction(int idAttraction) {
        this.idAttraction = idAttraction;
    }
}
