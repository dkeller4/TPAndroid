package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class PreferencePays {

    private int idPreference, idPays;

    public PreferencePays(){

    }

    public PreferencePays(int idPreference, int idPays) {
        this.idPreference = idPreference;
        this.idPays = idPays;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }
}
