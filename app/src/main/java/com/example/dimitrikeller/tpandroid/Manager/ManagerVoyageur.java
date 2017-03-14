package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerVoyageur {

    private static ArrayList<Voyageur> listeVoyageur;

    public static void init(){
        listeVoyageur = new ArrayList<>();
        listeVoyageur.add(new Voyageur(10, "Boule", "Bill", "29/10/1987", 10, "Canada", ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_pika, "Expert"));
        listeVoyageur.add(new Voyageur(20, "Astérix", "Et Obélix", "29/10/1987", 20, "France", ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_chat, "Expert"));
        listeVoyageur.add(new Voyageur(30, "Toto", "titi", "29/10/1987", 30, "Japon", ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_monde, "Expert"));
        listeVoyageur.add(new Voyageur(40, "bob", "avec cheveu", "29/10/1987", 40, "Brésil", ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_phoque, "Expert"));


    }

    public static ArrayList<Voyageur> getAll(){
        if(listeVoyageur == null)
            init();
        return listeVoyageur;
    }

    public static Voyageur getById(int idCompare){
        Voyageur retour = null;
        for (Voyageur v :
                listeVoyageur) {
            if(v.getIdVoyageur() == idCompare)
                retour = v;
        }
        return  retour;
    }

}