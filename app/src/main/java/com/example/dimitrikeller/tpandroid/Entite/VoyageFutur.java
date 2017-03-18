package com.example.dimitrikeller.tpandroid.Entite;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class VoyageFutur {

    private int idVoyageFutur;
    private int idPays;
    private int idVoyageurPrincipal;
    private String DateDepart;
    private String DateRetour;
    private Boolean estFlexible;
    private Boolean estComplet;
    private ArrayList<CompagnonVoyageFutur> listeCompagnonVoyageFutur;

    public VoyageFutur(){

    }

    public VoyageFutur(int idVoyageFutur, int idPays, int idVoyageurPrincipal, String dateDepart, String dateRetour, Boolean estFlexible, Boolean estComplet, ArrayList<CompagnonVoyageFutur> listeCompagnonVoyageFutur) {
        this.idVoyageFutur = idVoyageFutur;
        this.idPays = idPays;
        this.idVoyageurPrincipal = idVoyageurPrincipal;
        DateDepart = dateDepart;
        DateRetour = dateRetour;
        this.estFlexible = estFlexible;
        this.estComplet = estComplet;
        this.listeCompagnonVoyageFutur = listeCompagnonVoyageFutur;
    }

    public int getIdVoyageFutur() {
        return idVoyageFutur;
    }

    public void setIdVoyageFutur(int idVoyageFutur) {
        this.idVoyageFutur = idVoyageFutur;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getIdVoyageurPrincipal() {
        return idVoyageurPrincipal;
    }

    public void setIdVoyageurPrincipal(int idVoyageurPrincipal) {
        this.idVoyageurPrincipal = idVoyageurPrincipal;
    }

    public String getDateDepart() {
        return DateDepart;
    }

    public void setDateDepart(String dateDepart) {
        DateDepart = dateDepart;
    }

    public String getDateRetour() {
        return DateRetour;
    }

    public void setDateRetour(String dateRetour) {
        DateRetour = dateRetour;
    }

    public Boolean getEstFlexible() {
        return estFlexible;
    }

    public void setEstFlexible(Boolean estFlexible) {
        this.estFlexible = estFlexible;
    }

    public Boolean getEstComplet() {
        return estComplet;
    }

    public void setEstComplet(Boolean estComplet) {
        this.estComplet = estComplet;
    }

    public ArrayList<CompagnonVoyageFutur> getListeCompagnonVoyageFutur() {
        return listeCompagnonVoyageFutur;
    }

    public void setListeCompagnonVoyageFutur(ArrayList<CompagnonVoyageFutur> listeCompagnonVoyageFutur) {
        this.listeCompagnonVoyageFutur = listeCompagnonVoyageFutur;
    }
}
