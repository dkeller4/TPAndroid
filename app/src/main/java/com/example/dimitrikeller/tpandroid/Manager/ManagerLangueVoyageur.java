package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.InvitationVoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerLangueVoyageur {

    public static String LANGUE_VOYAGEUR_ID_LANGUE = "idLangue";
    public static String LANGUE_VOYAGEUR_ID_VOYAGEUR = "idvoyageur";
    public static String LANGUE_VOYAGEUR_TABLE = "langueVoyageur";

    public static String LANGUE_VOYAGEUR_TABLE_CREATE = "create table " + LANGUE_VOYAGEUR_TABLE + "(" +
            LANGUE_VOYAGEUR_ID_LANGUE + " INTEGER, " +
            LANGUE_VOYAGEUR_ID_VOYAGEUR + " INTEGER);";


    public static String DROP_LANGUE_PAYS_TABLE = "drop table if exists "+ LANGUE_VOYAGEUR_TABLE ;

    public static String queryGetAll = "select * from "+ LANGUE_VOYAGEUR_TABLE;



    public static ArrayList<LangueVoyageur> getAll(Context ctx){
        ArrayList<LangueVoyageur> listeLangueVoyageur = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            LangueVoyageur e = new LangueVoyageur();
            e.setIdLangue(c.getInt(0));
            e.setIdVoyageur(c.getInt(1));

            listeLangueVoyageur.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listeLangueVoyageur;
    }

    public static LangueVoyageur getByIdLangue(Context ctx, int idCompare){

        ArrayList<LangueVoyageur> listeLangueVoyageur = getAll(ctx);

        LangueVoyageur retour = null;
        for (LangueVoyageur l :
                listeLangueVoyageur) {
            if(l.getIdLangue() == idCompare)
                retour = l;
        }
        return  retour;
    }

    public static LangueVoyageur getByIdVoyageur(Context ctx, int idCompare){

        ArrayList<LangueVoyageur> listeLangueVoyageur = getAll(ctx);

        LangueVoyageur retour = null;
        for (LangueVoyageur l :
                listeLangueVoyageur) {
            if(l.getIdVoyageur() == idCompare)
                retour = l;
        }
        return  retour;
    }

    public static ArrayList<LangueVoyageur> getAllByIdVoyageur(Context ctx, int idCompare){
        ArrayList<LangueVoyageur> listeLangueVoyageur = getAll(ctx);

        ArrayList<LangueVoyageur> retour = new ArrayList<>();

        for (LangueVoyageur l :
                listeLangueVoyageur) {
            if(l.getIdVoyageur() == idCompare)
                retour.add(l);
        }
        return  retour;
    }

     /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(LangueVoyageur entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(LANGUE_VOYAGEUR_ID_LANGUE, entiteToAdd.getIdLangue());
        cv.put(LANGUE_VOYAGEUR_ID_VOYAGEUR, entiteToAdd.getIdVoyageur());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(LANGUE_VOYAGEUR_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id1, int id2, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(LANGUE_VOYAGEUR_TABLE, LANGUE_VOYAGEUR_ID_LANGUE + " = ? AND " + LANGUE_VOYAGEUR_ID_VOYAGEUR + " = ?", new String[]{String.valueOf(id1), String.valueOf(id2)});

    }

    // Modification

    public static void update(LangueVoyageur entite, Context ctx){
        ContentValues cv = new ContentValues();
         cv.put(LANGUE_VOYAGEUR_ID_LANGUE, entite.getIdLangue());
        cv.put(LANGUE_VOYAGEUR_ID_VOYAGEUR, entite.getIdVoyageur());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(LANGUE_VOYAGEUR_TABLE, cv, LANGUE_VOYAGEUR_ID_LANGUE + " = ? AND " + LANGUE_VOYAGEUR_ID_VOYAGEUR + " = ?" , new String[]{String.valueOf(entite.getIdLangue()), String.valueOf(entite.getIdVoyageur())});

    }

}
