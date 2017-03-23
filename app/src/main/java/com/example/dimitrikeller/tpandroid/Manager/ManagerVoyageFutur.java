package com.example.dimitrikeller.tpandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerVoyageFutur {


    public static String VOYAGE_FUTUR_ID = "id";
    public static String VOYAGE_FUTUR_ID_PAYS = "idPays";
    public static String VOYAGE_FUTUR_ID_VOYAGEUR = "idVoyageur";
    public static String VOYAGE_FUTUR_DATE_DEPART = "dateDepart";
    public static String VOYAGE_FUTUR_DATE_RETOUR = "dateRetour";
    public static String VOYAGE_FUTUR_FLEXIBLE = "estFlexible";
    public static String VOYAGE_FUTUR_COMPLET = "estComplet";
    public static String VOYAGE_FUTUR_TABLE ="voyageFutur";

    public static String VOYAGE_FUTUR_CREATE = "create table " + VOYAGE_FUTUR_TABLE + "("+
            VOYAGE_FUTUR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            VOYAGE_FUTUR_ID_PAYS + " INTEGER, " +
            VOYAGE_FUTUR_ID_VOYAGEUR + " INTEGER, " +
            VOYAGE_FUTUR_DATE_DEPART + " TEXT, " +
            VOYAGE_FUTUR_DATE_RETOUR + " TEXT, " +
            VOYAGE_FUTUR_FLEXIBLE + " INTEGER, "+
            VOYAGE_FUTUR_COMPLET + " INTEGER);";


    public static String DROP_VOYAGE_FUTUR_TABLE = "drop table if exists "+ VOYAGE_FUTUR_TABLE ;

    public static String queryGetAll = "select * from "+ VOYAGE_FUTUR_TABLE;



    public static ArrayList<VoyageFutur> getAll(Context ctx){
        ArrayList<VoyageFutur> listeVoyageFutur = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            VoyageFutur e = new VoyageFutur();
            e.setIdVoyageFutur(c.getInt(0));
            e.setIdPays(c.getInt(1));
            e.setIdVoyageurPrincipal(c.getInt(2));
            e.setDateDepart(c.getString(3));
            e.setDateRetour(c.getString(4));
            int estFlexible = c.getInt(5);
            if (estFlexible ==1){
                e.setEstFlexible(true);
            }
            else {
                e.setEstFlexible(false);
            }
            int estComplet = c.getInt(6);
            if (estComplet==1){
                e.setEstComplet(true);
            }
            else{
                e.setEstComplet(false);
            }
            e.setListeCompagnonVoyageFutur(ManagerCompagnonVoyageFutur.getAllByIdVoyageFutur(ctx, c.getInt(0)));
            listeVoyageFutur.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listeVoyageFutur;
    }

    public static VoyageFutur getByIdVoyageFutur(Context ctx, int idCompare){
        ArrayList<VoyageFutur> listeVoyageFutur = getAll(ctx);

        VoyageFutur retour = null;
        for (VoyageFutur v :
                listeVoyageFutur) {
            if(v.getIdVoyageFutur() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static VoyageFutur getByIdVoyageur(Context ctx, int idCompare){
        ArrayList<VoyageFutur> listeVoyageFutur = getAll(ctx);

        VoyageFutur retour = null;
        for (VoyageFutur v :
                listeVoyageFutur) {
            if(v.getIdVoyageurPrincipal() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static ArrayList<VoyageFutur> getAllByIdVoyageur(Context ctx, int idCompare){
        ArrayList<VoyageFutur> listeVoyageFutur = getAll(ctx);

        ArrayList<VoyageFutur> retour = new ArrayList<>();

        for (VoyageFutur v :
                listeVoyageFutur) {
            if(v.getIdVoyageurPrincipal() == idCompare)
                retour.add(v);
        }
        return  retour;
    }

    /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(VoyageFutur entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(VOYAGE_FUTUR_ID_VOYAGEUR, entiteToAdd.getIdVoyageurPrincipal());
        cv.put(VOYAGE_FUTUR_DATE_DEPART, entiteToAdd.getDateDepart());
        cv.put(VOYAGE_FUTUR_DATE_RETOUR, entiteToAdd.getDateRetour());
        cv.put(VOYAGE_FUTUR_FLEXIBLE, entiteToAdd.getEstFlexible());
        cv.put(VOYAGE_FUTUR_COMPLET, entiteToAdd.getEstComplet());


        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(VOYAGE_FUTUR_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(VOYAGE_FUTUR_TABLE, VOYAGE_FUTUR_ID + " = ?", new String[]{String.valueOf(id)});

    }

    // Modification

    public static void update(VoyageFutur entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(VOYAGE_FUTUR_ID_VOYAGEUR, entite.getIdVoyageurPrincipal());
        cv.put(VOYAGE_FUTUR_DATE_DEPART, entite.getDateDepart());
        cv.put(VOYAGE_FUTUR_DATE_RETOUR, entite.getDateRetour());
        cv.put(VOYAGE_FUTUR_FLEXIBLE, entite.getEstFlexible());
        cv.put(VOYAGE_FUTUR_COMPLET, entite.getEstComplet());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(VOYAGE_FUTUR_TABLE, cv, VOYAGE_FUTUR_ID + " = ?", new String[]{String.valueOf(entite.getIdVoyageFutur())});

    }


}
