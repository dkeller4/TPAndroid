package com.example.dimitrikeller.tpandroid.Manager;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Preference;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPreference {

    public static String PREFERENCE_ID = "idPreference";
    public static String PREFERENCE_TYPE = "typePreference";
    public static String PREFERENCE_TABLE = "Preference";

    public static String PREFERENCE_TABLE_CREATE = "create table " + PREFERENCE_TABLE + "(" +
            PREFERENCE_ID + " INTEGER PRIMARY KEY, " +
            PREFERENCE_TYPE + " TEXT);";

    public static String queryINSERT =
            "INSERT INTO `Preference` (idPreference,typePreference) VALUES (1,'Gastronomie'),\n" +
            " (2,'Histoire'),\n" +
            " (3,'Architecture'),\n" +
            " (4,'Nature'),\n" +
            " (5,'Technologie'),\n" +
            " (6,'Sport');";


    public static String DROP_PREFERENCE_TABLE = "drop table if exists "+ PREFERENCE_TABLE ;

    public static String queryGetAll = "select * from "+ PREFERENCE_TABLE;
    




    public static ArrayList<Preference> getAll(Context ctx){
        ArrayList<Preference> listePreference = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            Preference e = new Preference();
            e.setIdPreference(c.getInt(0));
            e.setType(c.getString(1));

            listePreference.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listePreference;
    }

    public static Preference getById(Context ctx, int idCompare){
        ArrayList<Preference> listePreference = getAll(ctx);

        Preference retour = null;
        for (Preference p :
                listePreference) {
            if(p.getIdPreference() == idCompare)
                retour = p;
        }
        return  retour;
    }


}
