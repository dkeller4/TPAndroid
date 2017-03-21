package com.example.dimitrikeller.tpandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;


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


/* Méthode de modification de la base de données*/

    //Ajout
    public static long add(Attraction entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(ATTRACTION_ID, entiteToAdd.getIdAttraction());
        cv.put(ATTRACTION_NOM, entiteToAdd.getNom());
        cv.put(ATTRACTION_DESCRIPTION, entiteToAdd.getDescription());
        cv.put(ATTRACTION_DUREE, entiteToAdd.getDuree());
        cv.put(ATTRACTION_VILLE, entiteToAdd.getVille());
        cv.put(ATTRACTION_TELEPHONE, entiteToAdd.getTelephone());
        cv.put(ATTRACTION_WEB, entiteToAdd.getWeb());
        cv.put(ATTRACTION_GRATUIT, entiteToAdd.getGratuit());
        cv.put(ATTRACTION_IMG, entiteToAdd.getRessImgAttraction());


        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(ATTRACTION_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(ATTRACTION_TABLE, ATTRACTION_ID + " = ?", new String[]{String.valueOf(id)});

    }

    // Modification

    public static void update(Attraction entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(ATTRACTION_ID, entite.getIdAttraction());
        cv.put(ATTRACTION_NOM, entite.getNom());
        cv.put(ATTRACTION_DESCRIPTION, entite.getDescription());
        cv.put(ATTRACTION_DUREE, entite.getDuree());
        cv.put(ATTRACTION_VILLE, entite.getVille());
        cv.put(ATTRACTION_TELEPHONE, entite.getTelephone());
        cv.put(ATTRACTION_WEB, entite.getWeb());
        cv.put(ATTRACTION_GRATUIT, entite.getGratuit());
        cv.put(ATTRACTION_IMG, entite.getIdAttraction());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(ATTRACTION_TABLE, cv, ATTRACTION_ID + " = ?", new String[]{String.valueOf(entite.getIdAttraction())});

    }



}
