package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
    public static String COMPAGNON_VOYAGE_FUTUR_TABLE = "attractionPays";

    public static String ATTRACTION_PAYS_TABLE_CREATE = "create table " + COMPAGNON_VOYAGE_FUTUR_TABLE + "(" +
            COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE + " INTEGER " +
            COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR+ "INTEGER);";

    public static String DROP_ATTRACTION_PAYS_TABLE = "drop table if exists + " + COMPAGNON_VOYAGE_FUTUR_TABLE;

    public static String queryGetAll = "select * from " + COMPAGNON_VOYAGE_FUTUR_TABLE;



    private static ArrayList<CompagnonVoyageFutur> listeCompagnon;

    public static void init(){
        listeCompagnon = new ArrayList<>();
        listeCompagnon.add(new CompagnonVoyageFutur(10, 10));
        listeCompagnon.add(new CompagnonVoyageFutur(20, 20));
        listeCompagnon.add(new CompagnonVoyageFutur(30, 30));
        listeCompagnon.add(new CompagnonVoyageFutur(40, 40));

    }

    public static ArrayList<CompagnonVoyageFutur> getAll(){
        if(listeCompagnon == null)
            init();
        return listeCompagnon;
    }

    public static CompagnonVoyageFutur getByIdVoyageurCompagnon(int idCompare){
        if(listeCompagnon == null)
            init();
        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageurCompagnon() == idCompare)
                retour = c;
        }
        return  retour;
    }

    public static CompagnonVoyageFutur getByIdVoyageFutur(int idCompare){
        if(listeCompagnon == null)
            init();
        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageFutur() == idCompare)
                retour = c;
        }
        return  retour;
    }

    public static ArrayList<CompagnonVoyageFutur> getAllByIdVoyageFutur(int idCompare){
        if(listeCompagnon == null)
            init();
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
