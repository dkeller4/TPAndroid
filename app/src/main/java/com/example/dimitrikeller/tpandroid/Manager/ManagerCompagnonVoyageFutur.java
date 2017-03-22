package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Entite.AttractionPays;
import com.example.dimitrikeller.tpandroid.Entite.CompagnonVoyageFutur;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerCompagnonVoyageFutur {


    public static String COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE = "idVoyage";
    public static String COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR ="idVoyageur";
    public static String COMPAGNON_VOYAGE_FUTUR_TABLE = "CompagnonVoyage";

    public static String COMPAGNON_VOYAGE_FUTUR_TABLE_CREATE = "create table " + COMPAGNON_VOYAGE_FUTUR_TABLE + "(" +
            COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE + " INTEGER " +
            COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR+ "INTEGER);";

    public static String DROP_ATTRACTION_PAYS_TABLE = "drop table if exists " + COMPAGNON_VOYAGE_FUTUR_TABLE;

    public static String queryGetAll = "select * from " + COMPAGNON_VOYAGE_FUTUR_TABLE;


    public static ArrayList<CompagnonVoyageFutur> getAll(Context ctx){

        ArrayList<CompagnonVoyageFutur> listeCompagnon = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            CompagnonVoyageFutur e = new CompagnonVoyageFutur();
            e.setIdVoyageFutur(c.getInt(0));
            e.setIdVoyageurCompagnon(c.getInt(1));

            listeCompagnon.add(e);
        }

        c.close();
        ConnexionBD.close();



        return listeCompagnon;
    }

    public static CompagnonVoyageFutur getByIdVoyageurCompagnon(Context ctx, int idCompare){
        ArrayList<CompagnonVoyageFutur> listeCompagnon = getAll(ctx);

        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageurCompagnon() == idCompare)
                retour = c;
        }
        return  retour;
    }

    public static CompagnonVoyageFutur getByIdVoyageFutur(Context ctx,int idCompare){
        ArrayList<CompagnonVoyageFutur> listeCompagnon = getAll(ctx);
        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageFutur() == idCompare)
                retour = c;
        }
        return  retour;
    }

    public static ArrayList<CompagnonVoyageFutur> getAllByIdVoyageFutur(Context ctx,int idCompare){
        ArrayList<CompagnonVoyageFutur> listeCompagnon = getAll(ctx);
        ArrayList<CompagnonVoyageFutur> retour = new ArrayList<>();

        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageFutur() == idCompare)
                retour.add(c);
        }
        return  retour;
    }


    /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(CompagnonVoyageFutur entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE,entiteToAdd.getIdVoyageFutur());
        cv.put(COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR,entiteToAdd.getIdVoyageurCompagnon());


        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(COMPAGNON_VOYAGE_FUTUR_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id1,int id2, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(COMPAGNON_VOYAGE_FUTUR_TABLE, COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE + " = ? AND " + COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR + " = ?", new String[]{String.valueOf(id1), String.valueOf(id2)});

    }

    // Modification

    public static void update(CompagnonVoyageFutur entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE,entite.getIdVoyageFutur());
        cv.put(COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR,entite.getIdVoyageurCompagnon());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(COMPAGNON_VOYAGE_FUTUR_TABLE, cv, COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE + " = ? AND " + COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR + " = ?", new String[]{String.valueOf(entite.getIdVoyageFutur()), String.valueOf(entite.getIdVoyageurCompagnon())});

    }




}
