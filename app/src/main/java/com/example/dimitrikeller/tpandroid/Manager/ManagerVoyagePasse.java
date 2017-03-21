package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.VoyagePasse;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerVoyagePasse {

    public static String VOYAGE_PASSE_ID = "id";
    public static String VOYAGE_PASSE_ID_VOYAGEUR = "idVoyageur";
    public static String VOYAGE_PASSE_ID_PAYS = "idPays";
    public static String VOYAGE_PASSE_TABLE;

    public static String VOYAGE_PASSE_TABLE_CREATE = "create table " + VOYAGE_PASSE_TABLE + "(" +
            VOYAGE_PASSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            VOYAGE_PASSE_ID_VOYAGEUR + " INTEGER, " +
            VOYAGE_PASSE_ID_PAYS + " INTEGER);";


    public static String DROP_VOYAGE_PASSE_TABLE = "drop table if exists "+ VOYAGE_PASSE_TABLE ;

    private static String queryGetAll = "select * from "+ VOYAGE_PASSE_TABLE;


    private static ArrayList<VoyagePasse> listeVoyagePasse;

    public static void init(){
        listeVoyagePasse = new ArrayList<>();
        listeVoyagePasse.add(new VoyagePasse(10, 10, 10));
        listeVoyagePasse.add(new VoyagePasse(10, 20, 20));
        listeVoyagePasse.add(new VoyagePasse(30, 30, 30));
        listeVoyagePasse.add(new VoyagePasse(40, 40, 40));
    }

    public static ArrayList<VoyagePasse> getAll(){
        if(listeVoyagePasse == null)
            init();
        return listeVoyagePasse;
    }

    public static VoyagePasse getByIdVoyage(int idCompare){
        if(listeVoyagePasse == null)
            init();
        VoyagePasse retour = null;
        for (VoyagePasse v :
                listeVoyagePasse) {
            if(v.getIdVoyage() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static VoyagePasse getByIdVoyageur(int idCompare){
        if(listeVoyagePasse == null)
            init();
        VoyagePasse retour = null;
        for (VoyagePasse v :
                listeVoyagePasse) {
            if(v.getIdVoyageur() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static ArrayList<VoyagePasse> getAllByIdVoyageur(int idCompare){
        if(listeVoyagePasse == null)
            init();
        ArrayList<VoyagePasse> retour = new ArrayList<>();

        for (VoyagePasse v :
                listeVoyagePasse) {
            if(v.getIdVoyageur() == idCompare)
                retour.add(v);
        }
        return  retour;
    }

}
