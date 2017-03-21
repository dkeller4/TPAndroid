package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.PreferenceVoyageur;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPreferenceVoyageur {

    public static String PREFERENCE_VOYAGEUR_ID_PREFERENCE = "idPreference";
    public static String PREFERENCE_VOYAGEUR_ID_VOYAGEUR = "idvoyageur";
    public static String PREFERENCE_VOYAGEUR_TABLE = "preferencePays";

    public static String PREFERENCE_VOYAGEUR_TABLE_CREATE = "create table " + PREFERENCE_VOYAGEUR_TABLE + "(" +
            PREFERENCE_VOYAGEUR_ID_PREFERENCE + " INTEGER, " +
            PREFERENCE_VOYAGEUR_ID_VOYAGEUR + " INTEGER);";


    public static String DROP_PREFERENCE_PAYS_TABLE = "drop table if exists "+ PREFERENCE_VOYAGEUR_TABLE ;

    private static String queryGetAll = "select * from "+ PREFERENCE_VOYAGEUR_TABLE;
    
    
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
        if(listePreferenceVoyageur == null)
            init();
        PreferenceVoyageur retour = null;
        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdPreference() == idCompare)
                retour = p;
        }
        return  retour;
    }

    public static PreferenceVoyageur getByIdVoyageur(int idCompare){
        if(listePreferenceVoyageur == null)
            init();
        PreferenceVoyageur retour = null;
        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdVoyageur() == idCompare)
                retour = p;
        }
        return  retour;
    }

    public static ArrayList<PreferenceVoyageur> getAllByIdVoyageur(int idCompare){
        if(listePreferenceVoyageur == null)
            init();
        ArrayList<PreferenceVoyageur> retour = new ArrayList<>();

        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdVoyageur() == idCompare)
                retour.add(p);
        }
        return  retour;
    }

}
