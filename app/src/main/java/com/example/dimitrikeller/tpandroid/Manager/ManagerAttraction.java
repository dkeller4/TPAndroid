package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.R;


import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerAttraction {

    public static String ATTRACTION_ID = "id";
    public static String ATTRACTION_NOM = "nom";
    public static String ATTRACTION_DESCRIPTION = "description";
    public static String ATTRACTION_DUREE = "duree";
    public static String ATTRACTION_VILLE = "ville";
    public static String ATTRACTION_TELEPHONE ="telephone";
    public static String ATTRACTION_WEB ="web";
    public static String ATTRACTION_GRATUIT = "gratuit";
    public static String ATTRACTION_IMG = "imgAttraction";
    public static String ATTRACTION_TABLE = "attraction";

    public static String ATTRACTION_TABLE_CREATE = "create table " + ATTRACTION_TABLE + "(" +
            ATTRACTION_ID + " INTEGER PRIMARY KEY, "+
            ATTRACTION_NOM + " TEXT, "+
            ATTRACTION_DESCRIPTION+ " TEXT, "+
            ATTRACTION_DUREE+ " TEXT, "+
            ATTRACTION_VILLE + " TEXT, "+
            ATTRACTION_TELEPHONE + " TEXT, "+
            ATTRACTION_WEB + " TEXT, "+
            ATTRACTION_GRATUIT + " TEXT, "+
            ATTRACTION_IMG + " TEXT);";

    public static String DROP_ATTRACTION_TABLE = "drop table if exists " + ATTRACTION_TABLE;

    private static String queryGetAll = "select * from "+ ATTRACTION_TABLE;


    private static ArrayList<Attraction> listeAttraction;


    public static void init(){
        listeAttraction = new ArrayList<>();
        listeAttraction.add(new Attraction(10, "Vieux-Québec", "Histoire,", "2 à 3 heures", "Québec", "555-555-5555", "http:www.google.ca", "oui", R.drawable.att_quebec));

    }

    public static ArrayList<Attraction> getAll(){
        if(listeAttraction == null)
            init();
        return listeAttraction;
    }

    public static Attraction getById(int idCompare){
        if(listeAttraction == null)
            init();
        Attraction retour = null;
        for (Attraction a :
                listeAttraction) {
            if(a.getIdAttraction() == idCompare)
                retour = a;
        }
        return  retour;
    }


}
