package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerLangueVoyageur {

    public static String LANGUE_VOYAGEUR_ID_LANGUE = "idLangue";
    public static String LANGUE_VOYAGEUR_ID_VOYAGEUR = "idvoyageur";
    public static String LANGUE_VOYAGEUR_TABLE = "languePays";

    public static String LANGUE_VOYAGEUR_TABLE_CREATE = "create table " + LANGUE_VOYAGEUR_TABLE + "(" +
            LANGUE_VOYAGEUR_ID_LANGUE + " INTEGER, " +
            LANGUE_VOYAGEUR_ID_VOYAGEUR + " INTEGER);";


    public static String DROP_LANGUE_PAYS_TABLE = "drop table if exists "+ LANGUE_VOYAGEUR_TABLE ;

    private static String queryGetAll = "select * from "+ LANGUE_VOYAGEUR_TABLE;




    private static ArrayList<LangueVoyageur> listeLangueVoyageur;

    public static void init(){
        listeLangueVoyageur = new ArrayList<>();
        listeLangueVoyageur.add(new LangueVoyageur(10, 10));
        listeLangueVoyageur.add(new LangueVoyageur(20, 20));
        listeLangueVoyageur.add(new LangueVoyageur(30, 30));
        listeLangueVoyageur.add(new LangueVoyageur(40, 40));

    }

    public static ArrayList<LangueVoyageur> getAll(){
        if(listeLangueVoyageur == null)
            init();
        return listeLangueVoyageur;
    }

    public static LangueVoyageur getByIdLangue(int idCompare){

        if(listeLangueVoyageur == null)
            init();
        LangueVoyageur retour = null;
        for (LangueVoyageur l :
                listeLangueVoyageur) {
            if(l.getIdLangue() == idCompare)
                retour = l;
        }
        return  retour;
    }

    public static LangueVoyageur getByIdVoyageur(int idCompare){

        if(listeLangueVoyageur == null)
            init();
        LangueVoyageur retour = null;
        for (LangueVoyageur l :
                listeLangueVoyageur) {
            if(l.getIdVoyageur() == idCompare)
                retour = l;
        }
        return  retour;
    }

    public static ArrayList<LangueVoyageur> getAllByIdVoyageur(int idCompare){
        if(listeLangueVoyageur == null)
            init();
        ArrayList<LangueVoyageur> retour = new ArrayList<>();

        for (LangueVoyageur l :
                listeLangueVoyageur) {
            if(l.getIdVoyageur() == idCompare)
                retour.add(l);
        }
        return  retour;
    }

}
