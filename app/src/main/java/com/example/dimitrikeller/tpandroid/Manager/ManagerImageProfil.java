package com.example.dimitrikeller.tpandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.ImageProfil;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-22.
 */

public class ManagerImageProfil {

    public static String IMG_ID = "idImg";
    public static String IMG_RESS = "ressImg";
    public static String IMG_TABLE = "imageProfil";

    public static String IMG_TABLE_CREATE = " create table " + IMG_TABLE + "(" +
            IMG_ID + " INTEGER PRIMARY KEY, " +
            IMG_RESS + " TEXT);";

    public static String queryINSERT = "INSERT INTO `ImageProfil` (idImg,ressImg) VALUES ('1','pr_champignon'),\n" +
            " ('2','pr_chat'),\n" +
            " ('3','pr_cheval'),\n" +
            " ('4','pr_dog'),\n" +
            " ('5','pr_fleur'),\n" +
            " ('6','pr_food'),\n" +
            " ('7','pr_grenouille'),\n" +
            " ('8','pr_lion'),\n" +
            " ('9','pr_monde'),\n" +
            " ('10','pr_montagne'),\n" +
            " ('11','pr_phoque'),\n" +
            " ('12','pr_pika'),\n" +
            " ('13','pr_smiley'),\n" +
            " ('14','pr_tortue'),\n" +
            " ('15','pr_valise');";


    public static String DROP_IMG_TABLE = "drop table if exists " + IMG_TABLE;

    public static String queryGetAll = "select * from " + IMG_TABLE;

    public static ArrayList<ImageProfil> getAll(Context ctx){
        ArrayList<ImageProfil> retour = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            ImageProfil p = new ImageProfil();
            p.setIdImage(c.getInt(0));
            p.setRessImage(c.getString(1));
            retour.add(p);
        }

        c.close();
        ConnexionBD.close();

        return retour;
    }

    /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(ImageProfil imgToAdd, Context ctx){
        long retour = -1;
        ContentValues values = new ContentValues();
        values.put(IMG_ID, imgToAdd.getIdImage());
        values.put(IMG_RESS, imgToAdd.getRessImage());



        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(IMG_TABLE,null,values);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(IMG_TABLE, IMG_ID + " = ?", new String[]{String.valueOf(id)});

    }

    // Modification

    public static void update(ImageProfil img, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(IMG_ID, img.getIdImage());
        cv.put(IMG_RESS, img.getRessImage());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(IMG_TABLE, cv, IMG_ID + " = ?", new String[]{String.valueOf(img.getIdImage())});

    }


}
