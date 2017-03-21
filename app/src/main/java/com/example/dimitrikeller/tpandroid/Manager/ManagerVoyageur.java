package com.example.dimitrikeller.tpandroid.Manager;


import android.content.ContentValues;
import android.content.Context;
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
            VOYAGEUR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            VOYAGEUR_NOM + " TEXT, "+
            VOYAGEUR_PRENOM + " TEXT, "+
            VOYAGEUR_DATE_NAISSANCE + " TEXT, " +
            VOYAGEUR_PAYS_NAISSANCE + " TEXT, " +
            VOYAGEUR_SEXE + " TEXT, " +
            VOYAGEUR_IMG_PROFIL + " TEXT, "+
            VOYAGEUR_CATEGORIE + " TEXT);";

    public static String DROP_VOYAGEUR_TABLE = "drop table if exists " + VOYAGEUR_TABLE;

    public static String queryGetAll = "select * from " + VOYAGEUR_TABLE;

    private static ArrayList<Voyageur> listeVoyageur;
    public static void init(){
        listeVoyageur = new ArrayList<>();
        listeVoyageur.add(new Voyageur(10, "Boule", "Bill", "29/10/1987",  "Canada", "f", ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_pika, "Expert"));
        listeVoyageur.add(new Voyageur(20, "Astérix", "Et Obélix", "29/10/1987",  "France", "h", ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_chat, "Expert"));
        listeVoyageur.add(new Voyageur(30, "Toto", "titi", "29/10/1987",  "Japon", "f",ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_monde, "Expert"));
        listeVoyageur.add(new Voyageur(40, "bob", "avec cheveu", "29/10/1987",  "Brésil", "h", ManagerVoyagePasse.getAll(), ManagerPreferenceVoyageur.getAll(), ManagerLangueVoyageur.getAll(), ManagerVoyageFutur.getAll(), R.drawable.pr_phoque, "Expert"));


    }

    public static ArrayList<Voyageur> getAll(){
        if(listeVoyageur == null)
            init();
        return listeVoyageur;
    }

    public static Voyageur getById(int idCompare){
        if(listeVoyageur == null)
            init();
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
        cv.put(VOYAGEUR_NOM,entiteToAdd.getNom());
        cv.put(VOYAGEUR_PRENOM,entiteToAdd.getPenom());
        cv.put(VOYAGEUR_DATE_NAISSANCE,entiteToAdd.getDateNaissance());
        cv.put(VOYAGEUR_PAYS_NAISSANCE, entiteToAdd.getDateNaissance());
        cv.put(VOYAGEUR_SEXE, entiteToAdd.getPaysNaissance());
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

    }

    // Modification

    public static void update(Voyageur entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(VOYAGEUR_NOM,entite.getNom());
        cv.put(VOYAGEUR_PRENOM, entite.getPenom());
        cv.put(VOYAGEUR_DATE_NAISSANCE, entite.getDateNaissance());
        cv.put(VOYAGEUR_PAYS_NAISSANCE, entite.getPaysNaissance());
        cv.put(VOYAGEUR_SEXE, entite.getSexe());
        cv.put(VOYAGEUR_IMG_PROFIL, entite.getRessImgProfil());
        cv.put(VOYAGEUR_CATEGORIE, entite.getCategorieVoyageur());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(VOYAGEUR_TABLE, cv, VOYAGEUR_ID + " = ?", new String[]{String.valueOf(entite.getIdVoyageur())});

    }


}
