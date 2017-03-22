package com.example.dimitrikeller.tpandroid.Manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.LanguePays;
import com.example.dimitrikeller.tpandroid.Entite.PreferencePays;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPreferencePays {

    public static String PREFERENCE_PAYS_ID_PAYS = "idPays";
    public static String PREFERENCE_PAYS_ID_PREFERENCE = "idPreference";

    public static String PREFERENCE_PAYS_TABLE = "preferencePays";

    public static String PREFERENCE_PAYS_TABLE_CREATE = "create table " + PREFERENCE_PAYS_TABLE + "(" +
            PREFERENCE_PAYS_ID_PAYS + " INTEGER," +
            PREFERENCE_PAYS_ID_PREFERENCE +" INTEGER);";

    public static String queryINSERT =
            "INSERT INTO `PreferencePays` (idPays,idPreference) VALUES (5,2),\n" +
            " (5,3),\n" +
            " (15,4),\n" +
            " (15,6),\n" +
            " (24,1),\n" +
            " (24,2),\n" +
            " (34,4),\n" +
            " (34,3),\n" +
            " (41,4),\n" +
            " (41,2),\n" +
            " (44,2),\n" +
            " (44,5),\n" +
            " (57,2),\n" +
            " (57,3),\n" +
            " (63,4),\n" +
            " (63,5),\n" +
            " (67,1),\n" +
            " (67,2),\n" +
            " (105,3),\n" +
            " (105,1),\n" +
            " (107,1),\n" +
            " (107,5);";


    public static String DROP_PREFERENCE_PAYS_TABLE = "drop table if exists "+ PREFERENCE_PAYS_TABLE ;

    public static String queryGetAll = "select * from "+ PREFERENCE_PAYS_TABLE;




    public static ArrayList<PreferencePays> getAll(Context ctx){
        ArrayList<PreferencePays> listePreferencePays = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            PreferencePays e = new PreferencePays();
            e.setIdPays(c.getInt(0));
            e.setIdPreference(c.getInt(1));

            listePreferencePays.add(e);
        }

        c.close();
        ConnexionBD.close();

        return listePreferencePays;
    }

    public static PreferencePays getByIdPreference(Context ctx, int idCompare){
        ArrayList<PreferencePays> listePreferencePays = getAll(ctx);

        PreferencePays retour = null;
        for (PreferencePays p :
                listePreferencePays) {
            if(p.getIdPreference() == idCompare)
                retour = p;
        }
        return  retour;
    }


    public static PreferencePays getByIdPays(Context ctx, int idCompare){
        ArrayList<PreferencePays> listePreferencePays = getAll(ctx);

        PreferencePays retour = null;
        for (PreferencePays p :
                listePreferencePays) {
            if(p.getIdPays() == idCompare)
                retour = p;
        }
        return  retour;
    }

    public static ArrayList<PreferencePays> getAllByIdPays(Context ctx, int idCompare){
        ArrayList<PreferencePays> listePreferencePays = getAll(ctx);

        ArrayList<PreferencePays> retour = new ArrayList<>();

        for (PreferencePays p :
                listePreferencePays) {
            if(p.getIdPays() == idCompare)
                retour.add(p);
        }
        return  retour;
    }

}
