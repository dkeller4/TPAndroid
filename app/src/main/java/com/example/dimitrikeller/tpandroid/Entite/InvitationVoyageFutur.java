package com.example.dimitrikeller.tpandroid.Entite;

/**
 * Created by Marianne on 2017-03-18.
 */

public class InvitationVoyageFutur {

    private int idInvitation;
    private int idVoyageFutur;
    private int idVoyageurEnvoyeur;
    private int idVoyageurReceveur;
    private boolean estEnAttente;
    private boolean estAccepte;

    public InvitationVoyageFutur(){

    }

    public InvitationVoyageFutur(int idInvitation, int idVoyageFutur, int idVoyageurEnvoyeur, int idVoyageurReceveur, boolean estEnAttente, boolean estAccepte) {
        this.idInvitation = idInvitation;
        this.idVoyageFutur = idVoyageFutur;
        this.idVoyageurEnvoyeur = idVoyageurEnvoyeur;
        this.idVoyageurReceveur = idVoyageurReceveur;
        this.estEnAttente = estEnAttente;
        this.estAccepte = estAccepte;
    }

    public int getIdInvitation() {
        return idInvitation;
    }

    public void setIdInvitation(int idInvitation) {
        this.idInvitation = idInvitation;
    }

    public int getIdVoyageFutur() {
        return idVoyageFutur;
    }

    public void setIdVoyageFutur(int idVoyageFutur) {
        this.idVoyageFutur = idVoyageFutur;
    }

    public int getIdVoyageurEnvoyeur() {
        return idVoyageurEnvoyeur;
    }

    public void setIdVoyageurEnvoyeur(int idVoyageurEnvoyeur) {
        this.idVoyageurEnvoyeur = idVoyageurEnvoyeur;
    }

    public int getIdVoyageurReceveur() {
        return idVoyageurReceveur;
    }

    public void setIdVoyageurReceveur(int idVoyageurReceveur) {
        this.idVoyageurReceveur = idVoyageurReceveur;
    }

    public boolean isEstEnAttente() {
        return estEnAttente;
    }

    public void setEstEnAttente(boolean estEnAttente) {
        this.estEnAttente = estEnAttente;
    }

    public boolean isEstAccepte() {
        return estAccepte;
    }

    public void setEstAccepte(boolean estAccepte) {
        this.estAccepte = estAccepte;
    }
}
