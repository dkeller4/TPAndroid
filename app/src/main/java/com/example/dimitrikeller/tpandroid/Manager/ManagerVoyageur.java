package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerVoyageur {



    public static String VOYAGEUR_ID="id";
    public static String VOYAGEUR_NOM = "nom";
    public static String VOYAGEUR_PRENOM = "prenom";
    public static String VOYAGEUR_DATE_NAISSANCE = "dateNaissance";
    public static String VOYAGEUR_PAYS_NAISSANCE = "paysNaissance";
    public static String VOYAGEUR_SEXE = "sexe";
    public static String VOYAGEUR_IMG_PROFIL = "imgProfil";
    public static String VOYAGEUR_CATEGORIE = "categorie";
    public static String VOYAGEUR_TABLE = "voyageur";

    public static String VOYAGEUR_TABLE_CREATE = "Create table " + VOYAGEUR_TABLE + "("+
            VOYAGEUR_ID + " INTEGER PRIMARY KEY , "+
            VOYAGEUR_NOM + " TEXT, "+
            VOYAGEUR_PRENOM + " TEXT, "+
            VOYAGEUR_DATE_NAISSANCE + " TEXT, " +
            VOYAGEUR_PAYS_NAISSANCE + " TEXT, " +
            VOYAGEUR_SEXE + " TEXT, " +
            VOYAGEUR_IMG_PROFIL + " TEXT, "+
            VOYAGEUR_CATEGORIE + " TEXT);";

    public static String queryInsertDemo = "INSERT INTO 'Voyageur' (id,prenom,nom,dateNaissance,paysNaissance,sexe,imgProfil,categorie) VALUES (1,'Marianne','Caron','29/10/1987','Canada','f','pr_pika','Grand explorateur'),\n" +
            " (2,'David','Jacques','08/10/1987','Canada','h','pr_champignon','Petit Explorateur');";

    public static String DROP_VOYAGEUR_TABLE = "drop table if exists " + VOYAGEUR_TABLE;

    public static String queryGetAll = "select * from " + VOYAGEUR_TABLE;



    public static ArrayList<Voyageur> getAll(Context ctx){
        ArrayList<Voyageur> listeVoyageur = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            Voyageur e = new Voyageur();
            e.setIdVoyageur(c.getInt(0));
            e.setNom(c.getString(1));
            e.setPenom(c.getString(2));
            e.setDateNaissance(c.getString(3));
            e.setPaysNaissance(c.getString(4));
            e.setSexe(c.getString(5));
            e.setRessImgProfil(c.getString(6));
            e.setCategorieVoyageur(c.getString(7));
            e.setListeInvitationVoyageFutur(ManagerInvitationVoyageFutur.getAllByIdVoyageurReceveur(ctx, c.getInt(0)));
            e.setListeLangueVoyageur(ManagerLangueVoyageur.getAllByIdVoyageur(ctx, c.getInt(0)));
            e.setListePreferenceVoyageur(ManagerPreferenceVoyageur.getAllByIdVoyageur(ctx, c.getInt(0)));
            e.setListeVoyageFutur(ManagerVoyageFutur.getAllByIdVoyageur(ctx, c.getInt(0)));
            e.setListeVoyagePasse(ManagerVoyagePasse.getAllByIdVoyageur(ctx, c.getInt(0)));

            listeVoyageur.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listeVoyageur;
    }

    public static Voyageur getById(Context ctx, int idCompare){
        ArrayList<Voyageur> listeVoyageur = getAll(ctx);

        Voyageur retour = null;
        for (Voyageur v :
                listeVoyageur) {
            if(v.getIdVoyageur() == idCompare)
                retour = v;
        }
        return  retour;
    }


/* Méthode de modification de la base de données*/

    //Ajout
    public static long add(Voyageur entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(VOYAGEUR_ID, entiteToAdd.getIdVoyageur());
        cv.put(VOYAGEUR_NOM,entiteToAdd.getNom());
        cv.put(VOYAGEUR_PRENOM,entiteToAdd.getPenom());
        cv.put(VOYAGEUR_DATE_NAISSANCE,entiteToAdd.getDateNaissance());
        cv.put(VOYAGEUR_PAYS_NAISSANCE, entiteToAdd.getPaysNaissance());
        cv.put(VOYAGEUR_SEXE, entiteToAdd.getSexe());
        cv.put(VOYAGEUR_IMG_PROFIL, entiteToAdd.getRessImgProfil());
        cv.put(VOYAGEUR_CATEGORIE, entiteToAdd.getCategorieVoyageur());


        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(VOYAGEUR_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(VOYAGEUR_TABLE, VOYAGEUR_ID + " = ?", new String[]{String.valueOf(id)});
        ConnexionBD.close();
    }

    // Modification

    public static void update(Voyageur entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(VOYAGEUR_ID, entite.getIdVoyageur());
        cv.put(VOYAGEUR_NOM,entite.getNom());
        cv.put(VOYAGEUR_PRENOM, entite.getPenom());
        cv.put(VOYAGEUR_DATE_NAISSANCE, entite.getDateNaissance());
        cv.put(VOYAGEUR_PAYS_NAISSANCE, entite.getPaysNaissance());
        cv.put(VOYAGEUR_SEXE, entite.getSexe());
        cv.put(VOYAGEUR_IMG_PROFIL, entite.getRessImgProfil());
        cv.put(VOYAGEUR_CATEGORIE, entite.getCategorieVoyageur());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(VOYAGEUR_TABLE, cv, VOYAGEUR_ID + " = ?", new String[]{String.valueOf(entite.getIdVoyageur())});
        ConnexionBD.close();
    }


}
