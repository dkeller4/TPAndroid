package com.example.dimitrikeller.tpandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.CompagnonVoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.InvitationVoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-18.
 */

public class ManagerInvitationVoyageFutur {


    public static String INVITATION_ID = "idInvitation";
    public static String INVITATION_ID_VOYAGE = "idVoyage";
    public static String INVITATION_ID_VOYAGEUR_ENVOYEUR = "idVoyageurEnvoyeur";
    public static String INVITATION_ID_VOYAGEUR_RECEVEUR = "idVoyageurReceveur";
    public static String INVITATION_ATTENTE = "estEnAttente";
    public static String INVITATION_ACCEPTE = "estAccepte";
    public static String INVITATION_TABLE = "invitation";

    public static String INVITATION_TABLE_CREATE = "create table "+ INVITATION_TABLE + "(" +
            INVITATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            INVITATION_ID_VOYAGE + " INTEGER, " +
            INVITATION_ID_VOYAGEUR_ENVOYEUR + " INTEGER, " +
            INVITATION_ID_VOYAGEUR_RECEVEUR + " INTEGER, " +
            INVITATION_ATTENTE + " INTEGER, " +
            INVITATION_ACCEPTE + " INTEGER);";


    public static String DROP_INVITATION_TABLE = "drop table if exists "+ INVITATION_TABLE ;

    public static String queryGetAll = "select * from "+ INVITATION_TABLE;


    public static ArrayList<InvitationVoyageFutur> getAll(Context ctx){
        ArrayList<InvitationVoyageFutur> listeInvitationVoyageFutur = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            InvitationVoyageFutur e = new InvitationVoyageFutur();
            e.setIdInvitation(c.getInt(0));
            e.setIdVoyageFutur(c.getInt(1));
            e.setIdVoyageurEnvoyeur(c.getInt(2));
            e.setIdVoyageurReceveur(c.getInt(3));
            int estEnAttente = c.getInt(4);
            if (estEnAttente == 1) {
                e.setEstEnAttente(true);
            }
            else {
                e.setEstEnAttente(false);
            }
            int estAccepte = c.getInt(5);
            if (estAccepte == 1) {
                e.setEstAccepte(true);
            }
            else {
                e.setEstAccepte(false);
            }

            listeInvitationVoyageFutur.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listeInvitationVoyageFutur;
    }

    public static InvitationVoyageFutur getByIdVoyageFutur(Context ctx, int idCompare){
        ArrayList<InvitationVoyageFutur> listeInvitationVoyageFutur = getAll(ctx);

        InvitationVoyageFutur retour = null;
        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageFutur() == idCompare)
                retour = v;
        }
        return  retour;
    }


    public static InvitationVoyageFutur getByIdVoyageurEnvoyeur(Context ctx, int idCompare){
        ArrayList<InvitationVoyageFutur> listeInvitationVoyageFutur = getAll(ctx);

        InvitationVoyageFutur retour = null;
        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurEnvoyeur() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static InvitationVoyageFutur getByIdVoyageurReceveur(Context ctx, int idCompare){
        ArrayList<InvitationVoyageFutur> listeInvitationVoyageFutur = getAll(ctx);

        InvitationVoyageFutur retour = null;
        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurReceveur() == idCompare)
                retour = v;
        }
        return  retour;
    }


    public static ArrayList<InvitationVoyageFutur> getAllByIdVoyageurEnvoyeur(Context ctx, int idCompare){
        ArrayList<InvitationVoyageFutur> listeInvitationVoyageFutur = getAll(ctx);

        ArrayList<InvitationVoyageFutur> retour = new ArrayList<>();

        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurEnvoyeur() == idCompare)
                retour.add(v);
        }
        return  retour;
    }

    public static ArrayList<InvitationVoyageFutur> getAllByIdVoyageurReceveur(Context ctx, int idCompare){
        ArrayList<InvitationVoyageFutur> listeInvitationVoyageFutur = getAll(ctx);

        ArrayList<InvitationVoyageFutur> retour = new ArrayList<>();

        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurReceveur() == idCompare)
                retour.add(v);
        }
        return  retour;
    }

    /* Méthode de modification de la base de données*/

    //Ajout
    public static long add(InvitationVoyageFutur entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();

        cv.put(INVITATION_ID_VOYAGE, entiteToAdd.getIdVoyageFutur());
        cv.put(INVITATION_ID_VOYAGEUR_ENVOYEUR, entiteToAdd.getIdVoyageurEnvoyeur());
        cv.put(INVITATION_ID_VOYAGEUR_RECEVEUR, entiteToAdd.getIdVoyageurReceveur());
        cv.put(INVITATION_ATTENTE, entiteToAdd.isEstEnAttente());
        cv.put(INVITATION_ACCEPTE, entiteToAdd.isEstAccepte());


        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(INVITATION_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id1, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(INVITATION_TABLE, INVITATION_ID + " = ? ", new String[]{String.valueOf(id1)});
        ConnexionBD.close();
    }

    // Modification

    public static void update(InvitationVoyageFutur entite, Context ctx){
        ContentValues cv = new ContentValues();

        cv.put(INVITATION_ID_VOYAGE, entite.getIdVoyageFutur());
        cv.put(INVITATION_ID_VOYAGEUR_ENVOYEUR, entite.getIdVoyageurEnvoyeur());
        cv.put(INVITATION_ID_VOYAGEUR_RECEVEUR, entite.getIdVoyageurReceveur());
        cv.put(INVITATION_ATTENTE, entite.isEstEnAttente());
        cv.put(INVITATION_ACCEPTE, entite.isEstAccepte());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(INVITATION_TABLE, cv, INVITATION_ID + " = ? " , new String[]{String.valueOf(entite.getIdInvitation())});
        ConnexionBD.close();
    }




}
