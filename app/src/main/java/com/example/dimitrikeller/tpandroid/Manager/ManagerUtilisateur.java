package com.example.dimitrikeller.tpandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Utilisateur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by mcaron1 on 2017-03-22.
 */

public class ManagerUtilisateur {

    public static String UTILISATEUR_ID="idUtilisateur";
    public static String UTILISATEUR_IDENTIFIANT = "identifiant";
    public static String UTILISATEUR_MOTPASSE = "motDePasse";
    public static String UTILISATEUR_TABLE = "utilisateur";

    public static String VOYAGEUR_TABLE_CREATE = "Create table " + UTILISATEUR_TABLE + "("+
            UTILISATEUR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "+
            UTILISATEUR_IDENTIFIANT + " TEXT, "+
            UTILISATEUR_MOTPASSE + " TEXT);";

    public static String DROP_UTILISATEUR_TABLE = "drop table if exists " + UTILISATEUR_TABLE;

    public static String queryGetAll = "select * from " + UTILISATEUR_TABLE;



    public static ArrayList<Utilisateur> getAll(Context ctx){
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            Utilisateur e = new Utilisateur();
            e.setIdVoyageur(c.getInt(0));
            e.setIdentifiant(c.getString(1));
            e.setMotPasse(c.getString(2));

            listeUtilisateur.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listeUtilisateur;
    }

    public static Utilisateur getById(Context ctx, int idCompare){
        ArrayList<Utilisateur> listeUtilisateur = getAll(ctx);

        Utilisateur retour = null;
        for (Utilisateur v :
                listeUtilisateur) {
            if(v.getIdVoyageur() == idCompare)
                retour = v;
        }
        return  retour;
    }


/* Méthode de modification de la base de données*/

    //Ajout
    public static long add(Utilisateur entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();

        cv.put(UTILISATEUR_IDENTIFIANT, entiteToAdd.getIdentifiant());
        cv.put(UTILISATEUR_MOTPASSE, entiteToAdd.getMotPasse());



        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(UTILISATEUR_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(UTILISATEUR_TABLE, UTILISATEUR_ID + " = ?", new String[]{String.valueOf(id)});

    }

    // Modification

    public static void update(Utilisateur entite, Context ctx){
        ContentValues cv = new ContentValues();

        cv.put(UTILISATEUR_IDENTIFIANT, entite.getIdentifiant());
        cv.put(UTILISATEUR_MOTPASSE, entite.getMotPasse());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(UTILISATEUR_TABLE, cv, UTILISATEUR_ID + " = ?", new String[]{String.valueOf(entite.getIdVoyageur())});

    }


}
