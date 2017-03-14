package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.PreferenceVoyageur;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPreferenceVoyageur {


    private static ArrayList<PreferenceVoyageur> listePreferenceVoyageur;

    public static void init(){
        listePreferenceVoyageur = new ArrayList<>();
        listePreferenceVoyageur.add(new PreferenceVoyageur(10, 10));
        listePreferenceVoyageur.add(new PreferenceVoyageur(20, 20));
        listePreferenceVoyageur.add(new PreferenceVoyageur(30, 30));
        listePreferenceVoyageur.add(new PreferenceVoyageur(40, 40));

    }

    public static ArrayList<PreferenceVoyageur> getAll(){
        if(listePreferenceVoyageur == null)
            init();
        return listePreferenceVoyageur;
    }

    public static PreferenceVoyageur getByIdPreference(int idCompare){
        PreferenceVoyageur retour = null;
        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdPreference() == idCompare)
                retour = p;
        }
        return  retour;
    }

    public static PreferenceVoyageur getByIdVoyageur(int idCompare){
        PreferenceVoyageur retour = null;
        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdVoyageur() == idCompare)
                retour = p;
        }
        return  retour;
    }

}
