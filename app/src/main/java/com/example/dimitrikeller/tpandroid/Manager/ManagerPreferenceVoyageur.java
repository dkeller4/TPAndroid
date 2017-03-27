package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.PreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPreferenceVoyageur {

    public static String PREFERENCE_VOYAGEUR_ID_PREFERENCE = "idPreference";
    public static String PREFERENCE_VOYAGEUR_ID_VOYAGEUR = "idvoyageur";
    public static String PREFERENCE_VOYAGEUR_TABLE = "preferenceVoyageur";

    public static String PREFERENCE_VOYAGEUR_TABLE_CREATE = "create table " + PREFERENCE_VOYAGEUR_TABLE + "(" +
            PREFERENCE_VOYAGEUR_ID_PREFERENCE + " INTEGER, " +
            PREFERENCE_VOYAGEUR_ID_VOYAGEUR + " INTEGER);";


    public static String queryInsertDemo = "INSERT INTO `preferenceVoyageur` (idVoyageur,idPreference) VALUES (1,1),\n" +
            " (1,2),\n" +
            " (2,1),\n" +
            " (2,5);";

    public static String DROP_PREFERENCE_PAYS_TABLE = "drop table if exists "+ PREFERENCE_VOYAGEUR_TABLE ;

    public static String queryGetAll = "select * from "+ PREFERENCE_VOYAGEUR_TABLE;
    



    public static ArrayList<PreferenceVoyageur> getAll(Context ctx){
        ArrayList<PreferenceVoyageur> listePreferenceVoyageur = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            PreferenceVoyageur e = new PreferenceVoyageur();
            e.setIdPreference(c.getInt(0));
            e.setIdVoyageur(c.getInt(1));

            listePreferenceVoyageur.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listePreferenceVoyageur;
    }

    public static PreferenceVoyageur getByIdPreference(Context ctx, int idCompare){
        ArrayList<PreferenceVoyageur> listePreferenceVoyageur = getAll(ctx);

        PreferenceVoyageur retour = null;
        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdPreference() == idCompare)
                retour = p;
        }
        return  retour;
    }

    public static PreferenceVoyageur getByIdVoyageur(Context ctx, int idCompare){
        ArrayList<PreferenceVoyageur> listePreferenceVoyageur = getAll(ctx);

        PreferenceVoyageur retour = null;
        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdVoyageur() == idCompare)
                retour = p;
        }
        return  retour;
    }

    public static ArrayList<PreferenceVoyageur> getAllByIdVoyageur(Context ctx, int idCompare){
        ArrayList<PreferenceVoyageur> listePreferenceVoyageur = getAll(ctx);

        ArrayList<PreferenceVoyageur> retour = new ArrayList<>();

        for (PreferenceVoyageur p :
                listePreferenceVoyageur) {
            if(p.getIdVoyageur() == idCompare)
                retour.add(p);
        }
        return  retour;
    }

    /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(PreferenceVoyageur entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(PREFERENCE_VOYAGEUR_ID_PREFERENCE, entiteToAdd.getIdPreference());
        cv.put(PREFERENCE_VOYAGEUR_ID_VOYAGEUR,entiteToAdd.getIdVoyageur());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(PREFERENCE_VOYAGEUR_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id1, int id2, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(PREFERENCE_VOYAGEUR_TABLE, PREFERENCE_VOYAGEUR_ID_PREFERENCE + " = ? AND " + PREFERENCE_VOYAGEUR_ID_VOYAGEUR + " = ?", new String[]{String.valueOf(id1), String.valueOf(id2)});
        ConnexionBD.close();
    }

    // Modification

    public static void update(PreferenceVoyageur entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(PREFERENCE_VOYAGEUR_ID_PREFERENCE, entite.getIdPreference());
        cv.put(PREFERENCE_VOYAGEUR_ID_VOYAGEUR, entite.getIdVoyageur());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(PREFERENCE_VOYAGEUR_TABLE, cv, PREFERENCE_VOYAGEUR_ID_PREFERENCE + " = ? AND " + PREFERENCE_VOYAGEUR_ID_VOYAGEUR + " = ?" , new String[]{String.valueOf(entite.getIdPreference()), String.valueOf(entite.getIdVoyageur())});
        ConnexionBD.close();
    }


}
