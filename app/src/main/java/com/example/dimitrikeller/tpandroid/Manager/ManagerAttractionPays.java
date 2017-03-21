package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Entite.AttractionPays;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;


import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerAttractionPays {


    public static String ATTRACTION_PAYS_ID_PAYS = "idPays";
    public static String ATTRACTION_PAYS_ID_ATTRACTION ="idAttraction";
    public static String ATTRACTION_PAYS_TABLE = "attractionPays";

    public static String ATTRACTION_PAYS_TABLE_CREATE = "create table " + ATTRACTION_PAYS_TABLE + "(" +
            ATTRACTION_PAYS_ID_PAYS + " INTEGER " +
            ATTRACTION_PAYS_ID_ATTRACTION+ "INTEGER);";

    public static String DROP_ATTRACTION_PAYS_TABLE = "drop table if exists + " + ATTRACTION_PAYS_TABLE;

    public static String queryGetAll = "select * from " + ATTRACTION_PAYS_TABLE;

    private static ArrayList<AttractionPays> listeAttraction;

    public static void init(){
        listeAttraction = new ArrayList<>();
        listeAttraction.add(new AttractionPays(10, 10));
        listeAttraction.add(new AttractionPays(20, 20));
        listeAttraction.add(new AttractionPays(30, 30));
        listeAttraction.add(new AttractionPays(40, 40));

    }

    public static ArrayList<AttractionPays> getAll(){
        if(listeAttraction == null)
            init();
        return listeAttraction;
    }

    public static AttractionPays getByIdAttraction(int idCompare){
        if(listeAttraction == null)
            init();
        AttractionPays retour = null;
        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdAttraction() == idCompare)
                retour = a;
        }
        return  retour;
    }

    public static AttractionPays getByIdPays(int idCompare){
        if(listeAttraction == null)
            init();
        AttractionPays retour = null;
        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdPays() == idCompare)
                retour = a;
        }
        return  retour;
    }

    public static ArrayList<AttractionPays> getAllByIdPays(int idCompare){
        if(listeAttraction == null)
            init();
        ArrayList<AttractionPays> retour = new ArrayList<>();

        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdPays() == idCompare)
                retour.add(a);
        }
        return  retour;
    }


    /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(AttractionPays entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(ATTRACTION_PAYS_ID_PAYS,entiteToAdd.getIdPays());
        cv.put(ATTRACTION_PAYS_ID_ATTRACTION,entiteToAdd.getIdAttraction());


        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(ATTRACTION_PAYS_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(ATTRACTION_PAYS_TABLE, ATTRACTION_PAYS_ID_ATTRACTION + " = ?", new String[]{String.valueOf(id)});

    }

    // Modification

    public static void update(AttractionPays entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(ATTRACTION_PAYS_ID_PAYS,entite.getIdAttraction());
        cv.put(ATTRACTION_PAYS_ID_PAYS,entite.getIdPays());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(ATTRACTION_PAYS_TABLE, cv, ATTRACTION_PAYS_ID_ATTRACTION + " = ?", new String[]{String.valueOf(entite.getIdAttraction())});

    }


}
