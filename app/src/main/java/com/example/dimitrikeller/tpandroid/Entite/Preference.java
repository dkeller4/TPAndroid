package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-13.
 */

public class Preference {

    private int idPreference;
    private String type;

    public Preference(){

    }

    public Preference(int idPreference, String type) {
        this.idPreference = idPreference;
        this.type = type;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
