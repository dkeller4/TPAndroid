package com.example.dimitrikeller.tpandroid.Entite;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class Voyageur {



    private int idVoyageur;
    private String penom;
    private String nom;
    private String dateNaissance;
    private int idPaysNaissance;
    private String PaysNaissance;
    private String sexe;
    private ArrayList<VoyagePasse> listeVoyagePasse;
    private ArrayList<PreferenceVoyageur> listePreferenceVoyageur;
    private ArrayList<LangueVoyageur> listeLangueVoyageur;
    private ArrayList<VoyageFutur> listeVoyageFutur;
    private int RessImgProfil;
    private String categorieVoyageur;


    public Voyageur(){

    }

    public Voyageur(int idVoyageur, String penom, String nom, String dateNaissance, int idPaysNaissance, String paysNaissance, String sexe, ArrayList<VoyagePasse> listeVoyagePasse, ArrayList<PreferenceVoyageur> listePreferenceVoyageur, ArrayList<LangueVoyageur> listeLangueVoyageur, ArrayList<VoyageFutur> listeVoyageFutur, int ressImgProfil, String categorieVoyageur) {
        this.idVoyageur = idVoyageur;
        this.penom = penom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.idPaysNaissance = idPaysNaissance;
        this.sexe = sexe;
        PaysNaissance = paysNaissance;
        this.listeVoyagePasse = listeVoyagePasse;
        this.listePreferenceVoyageur = listePreferenceVoyageur;
        this.listeLangueVoyageur = listeLangueVoyageur;
        this.listeVoyageFutur = listeVoyageFutur;
        RessImgProfil = ressImgProfil;
        this.categorieVoyageur = categorieVoyageur;



    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getIdVoyageur() {
        return idVoyageur;
    }

    public void setIdVoyageur(int idVoyageur) {
        this.idVoyageur = idVoyageur;
    }

    public String getPenom() {
        return penom;
    }

    public void setPenom(String penom) {
        this.penom = penom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getIdPaysNaissance() {
        return idPaysNaissance;
    }

    public void setIdPaysNaissance(int idPaysNaissance) {
        this.idPaysNaissance = idPaysNaissance;
    }

    public String getPaysNaissance() {
        return PaysNaissance;
    }

    public void setPaysNaissance(String paysNaissance) {
        PaysNaissance = paysNaissance;
    }

    public ArrayList<VoyagePasse> getListeVoyagePasse() {
        return listeVoyagePasse;
    }

    public void setListeVoyagePasse(ArrayList<VoyagePasse> listeVoyagePasse) {
        this.listeVoyagePasse = listeVoyagePasse;
    }

    public ArrayList<PreferenceVoyageur> getListePreferenceVoyageur() {
        return listePreferenceVoyageur;
    }

    public void setListePreferenceVoyageur(ArrayList<PreferenceVoyageur> listePreferenceVoyageur) {
        this.listePreferenceVoyageur = listePreferenceVoyageur;
    }

    public ArrayList<LangueVoyageur> getListeLangueVoyageur() {
        return listeLangueVoyageur;
    }

    public void setListeLangueVoyageur(ArrayList<LangueVoyageur> listeLangueVoyageur) {
        this.listeLangueVoyageur = listeLangueVoyageur;
    }

    public ArrayList<VoyageFutur> getListeVoyageFutur() {
        return listeVoyageFutur;
    }

    public void setListeVoyageFutur(ArrayList<VoyageFutur> listeVoyageFutur) {
        this.listeVoyageFutur = listeVoyageFutur;
    }

    public int getRessImgProfil() {
        return RessImgProfil;
    }

    public void setRessImgProfil(int ressImgProfil) {
        RessImgProfil = ressImgProfil;
    }

    public String getCategorieVoyageur() {
        return categorieVoyageur;
    }

    public void setCategorieVoyageur(String categorieVoyageur) {
        this.categorieVoyageur = categorieVoyageur;
    }




}
