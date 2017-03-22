package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static String ATTRACTION_PAYS_TABLE = "AttractionPays";

    public static String ATTRACTION_PAYS_TABLE_CREATE = "create table  " + ATTRACTION_PAYS_TABLE + "(" +
            ATTRACTION_PAYS_ID_PAYS + " INTEGER, " +
            ATTRACTION_PAYS_ID_ATTRACTION+ " INTEGER ); ";

    public static String queryINSERT =
            "INSERT INTO `AttractionPays` (idPays,idAttraction) VALUES (5,1),\n" +
            " (5,2),\n" +
            " (5,3),\n" +
            " (5,4),\n" +
            " (5,5),\n" +
            " (15,6),\n" +
            " (15,7),\n" +
            " (15,8),\n" +
            " (15,9),\n" +
            " (15,10),\n" +
            " (24,11),\n" +
            " (24,12),\n" +
            " (24,13),\n" +
            " (24,14),\n" +
            " (24,15),\n" +
            " (34,16),\n" +
            " (34,17),\n" +
            " (34,18),\n" +
            " (34,19),\n" +
            " (34,20),\n" +
            " (41,21),\n" +
            " (41,22),\n" +
            " (41,23),\n" +
            " (41,24),\n" +
            " (41,25),\n" +
            " (44,26),\n" +
            " (44,27),\n" +
            " (44,28),\n" +
            " (44,29),\n" +
            " (44,30),\n" +
            " (57,31),\n" +
            " (57,32),\n" +
            " (57,33),\n" +
            " (57,34),\n" +
            " (57,35),\n" +
            " (63,36),\n" +
            " (63,37),\n" +
            " (63,38),\n" +
            " (63,39),\n" +
            " (63,40),\n" +
            " (67,41),\n" +
            " (67,42),\n" +
            " (67,43),\n" +
            " (67,44),\n" +
            " (67,45),\n" +
            " (105,46),\n" +
            " (105,47),\n" +
            " (105,48),\n" +
            " (105,49),\n" +
            " (105,50),\n" +
            " (107,51),\n" +
            " (107,52),\n" +
            " (107,53),\n" +
            " (107,54),\n" +
            " (107,55);";


    public static String DROP_ATTRACTION_PAYS_TABLE = "drop table if exists  " + ATTRACTION_PAYS_TABLE;

    public static String queryGetAll = "select * from " + ATTRACTION_PAYS_TABLE;



    public static ArrayList<AttractionPays> getAll(Context ctx){
        ArrayList<AttractionPays> listeAttractionPays = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            AttractionPays e = new AttractionPays();
            e.setIdPays(c.getInt(0));
            e.setIdAttraction(c.getInt(1));

            listeAttractionPays.add(e);

        }

        c.close();
        ConnexionBD.close();

        return listeAttractionPays;
    }

    public static AttractionPays getByIdAttraction(Context ctx, int idCompare){
        ArrayList<AttractionPays> listeAttraction = getAll(ctx);

        AttractionPays retour = null;
        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdAttraction() == idCompare)
                retour = a;
        }
        return  retour;
    }

    public static AttractionPays getByIdPays(Context ctx, int idCompare){
        ArrayList<AttractionPays> listeAttraction = getAll(ctx);

        AttractionPays retour = null;
        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdPays() == idCompare)
                retour = a;
        }
        return  retour;
    }

    public static ArrayList<AttractionPays> getAllByIdPays(Context ctx,int idCompare){
        ArrayList<AttractionPays> listeAttraction = getAll(ctx);

        ArrayList<AttractionPays> retour = new ArrayList<>();

        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdPays() == idCompare)
                retour.add(a);
        }
        return  retour;
    }


    /* Méthode de modification de la base de données

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

*/
}
