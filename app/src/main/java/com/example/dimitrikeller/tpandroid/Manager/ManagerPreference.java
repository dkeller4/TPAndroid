package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.Preference;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPreference {

    public static String PREFERENCE_ID = "id";
    public static String PREFERENCE_TYPE = "typePreference";
    public static String PREFERENCE_TABLE;

    public static String PREFERENCE_TABLE_CREATE = "create table " + PREFERENCE_TABLE + "(" +
            PREFERENCE_ID + " INTEGER PRIMARY KEY, " +
            PREFERENCE_TYPE + " TEXT);";


    public static String DROP_PREFERENCE_TABLE = "drop table if exists "+ PREFERENCE_TABLE ;

    private static String queryGetAll = "select * from "+ PREFERENCE_TABLE;
    

    private static ArrayList<Preference> listePreference;

    public static void init(){
        listePreference = new ArrayList<>();
        listePreference.add(new Preference(10, "Gastronomie"));
        listePreference.add(new Preference(20, "Histoire"));
        listePreference.add(new Preference(30, "Sport Extrême"));
        listePreference.add(new Preference(40, "Nature"));

    }

    public static ArrayList<Preference> getAll(){
        if(listePreference == null)
            init();
        return listePreference;
    }

    public static Preference getById(int idCompare){
        if(listePreference == null)
            init();
        Preference retour = null;
        for (Preference p :
                listePreference) {
            if(p.getIdPreference() == idCompare)
                retour = p;
        }
        return  retour;
    }


}
