package com.example.dimitrikeller.tpandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.VoyagePasse;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerVoyagePasse {

    public static String VOYAGE_PASSE_ID = "id";
    public static String VOYAGE_PASSE_ID_VOYAGEUR = "idVoyageur";
    public static String VOYAGE_PASSE_ID_PAYS = "idPays";
    public static String VOYAGE_PASSE_TABLE = "voyagePasse";

    public static String VOYAGE_PASSE_TABLE_CREATE = "create table " + VOYAGE_PASSE_TABLE + "(" +
            VOYAGE_PASSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            VOYAGE_PASSE_ID_VOYAGEUR + " INTEGER, " +
            VOYAGE_PASSE_ID_PAYS + " INTEGER);";


    public static String DROP_VOYAGE_PASSE_TABLE = "drop table if exists "+ VOYAGE_PASSE_TABLE ;

    public static String queryGetAll = "select * from "+ VOYAGE_PASSE_TABLE;



    public static ArrayList<VoyagePasse> getAll(Context ctx){
        ArrayList<VoyagePasse> listeVoyagePasse = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            VoyagePasse e = new VoyagePasse();
            e.setIdVoyage(c.getInt(0));
            e.setIdVoyageur(c.getInt(1));
            e.setIdPays(c.getInt(2));

            listeVoyagePasse.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listeVoyagePasse;
    }

    public static VoyagePasse getByIdVoyage(Context ctx, int idCompare){
        ArrayList<VoyagePasse> listeVoyagePasse = getAll(ctx);

        VoyagePasse retour = null;
        for (VoyagePasse v :
                listeVoyagePasse) {
            if(v.getIdVoyage() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static VoyagePasse getByIdVoyageur(Context ctx, int idCompare){
        ArrayList<VoyagePasse> listeVoyagePasse = getAll(ctx);

        VoyagePasse retour = null;
        for (VoyagePasse v :
                listeVoyagePasse) {
            if(v.getIdVoyageur() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static ArrayList<VoyagePasse> getAllByIdVoyageur(Context ctx, int idCompare){
        ArrayList<VoyagePasse> listeVoyagePasse = getAll(ctx);

        ArrayList<VoyagePasse> retour = new ArrayList<>();

        for (VoyagePasse v :
                listeVoyagePasse) {
            if(v.getIdVoyageur() == idCompare)
                retour.add(v);
        }
        return  retour;
    }

    /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(VoyagePasse entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(VOYAGE_PASSE_ID, entiteToAdd.getIdVoyage());
        cv.put(VOYAGE_PASSE_ID_VOYAGEUR, entiteToAdd.getIdVoyageur());
        cv.put(VOYAGE_PASSE_ID_PAYS, entiteToAdd.getIdPays());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(VOYAGE_PASSE_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(VOYAGE_PASSE_TABLE, VOYAGE_PASSE_ID + " = ?", new String[]{String.valueOf(id)});

    }

    // Modification

    public static void update(VoyagePasse entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(VOYAGE_PASSE_ID, entite.getIdVoyage());
        cv.put(VOYAGE_PASSE_ID_VOYAGEUR, entite.getIdVoyageur());
        cv.put(VOYAGE_PASSE_ID_PAYS, entite.getIdPays());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(VOYAGE_PASSE_TABLE, cv, VOYAGE_PASSE_ID + " = ?", new String[]{String.valueOf(entite.getIdVoyage())});

    }



}
