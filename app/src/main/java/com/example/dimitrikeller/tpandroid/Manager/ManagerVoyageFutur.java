package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;

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
    public static String VOYAGE_FUTUR_TABLE;

    public static String VOYAGE_FUTUR_CREATE = "create table " + VOYAGE_FUTUR_TABLE + "("+
            VOYAGE_FUTUR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
            VOYAGE_FUTUR_ID_PAYS + " INTEGER, " +
            VOYAGE_FUTUR_ID_VOYAGEUR + " INTEGER, " +
            VOYAGE_FUTUR_DATE_DEPART + " TEXT, " +
            VOYAGE_FUTUR_DATE_RETOUR + " TEXT, " +
            VOYAGE_FUTUR_FLEXIBLE + " INTEGER, "+
            VOYAGE_FUTUR_COMPLET + " INTEGER);";


    public static String DROP_VOYAGE_FUTUR_TABLE = "drop table if exists "+ VOYAGE_FUTUR_TABLE ;

    private static String queryGetAll = "select * from "+ VOYAGE_FUTUR_TABLE;


    private static ArrayList<VoyageFutur> listeVoyageFutur;

    public static void init(){
        listeVoyageFutur = new ArrayList<>();
        listeVoyageFutur.add(new VoyageFutur(10, 10, 10, "31/12/2016", "30/01/2017", true, false, ManagerCompagnonVoyageFutur.getAll()));
        listeVoyageFutur.add(new VoyageFutur(20, 20, 10, "31/12/2016", "30/01/2017", true, false, ManagerCompagnonVoyageFutur.getAll()));
        listeVoyageFutur.add(new VoyageFutur(30, 30, 30, "31/12/2016", "30/01/2017", true, false, ManagerCompagnonVoyageFutur.getAll()));
        listeVoyageFutur.add(new VoyageFutur(40, 40, 40, "31/12/2016", "30/01/2017", true, false, ManagerCompagnonVoyageFutur.getAll()));
    }

    public static ArrayList<VoyageFutur> getAll(){
        if(listeVoyageFutur == null)
            init();
        return listeVoyageFutur;
    }

    public static VoyageFutur getByIdVoyageFutur(int idCompare){
        if(listeVoyageFutur == null)
            init();
        VoyageFutur retour = null;
        for (VoyageFutur v :
                listeVoyageFutur) {
            if(v.getIdVoyageFutur() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static VoyageFutur getByIdVoyageur(int idCompare){
        if(listeVoyageFutur == null)
            init();
        VoyageFutur retour = null;
        for (VoyageFutur v :
                listeVoyageFutur) {
            if(v.getIdVoyageurPrincipal() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static ArrayList<VoyageFutur> getAllByIdVoyageur(int idCompare){
        if(listeVoyageFutur == null)
            init();
        ArrayList<VoyageFutur> retour = new ArrayList<>();

        for (VoyageFutur v :
                listeVoyageFutur) {
            if(v.getIdVoyageurPrincipal() == idCompare)
                retour.add(v);
        }
        return  retour;
    }

}
