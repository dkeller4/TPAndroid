package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.CompagnonVoyageFutur;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerCompagnonVoyageFutur {


    public static String COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE = "idVoyage";
    public static String COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR ="idVoyageur";
    public static String COMPAGNON_VOYAGE_FUTUR_TABLE = "attractionPays";

    public static String ATTRACTION_PAYS_TABLE_CREATE = "create table " + COMPAGNON_VOYAGE_FUTUR_TABLE + "(" +
            COMPAGNON_VOYAGE_FUTUR_ID_VOYAGE + " INTEGER " +
            COMPAGNON_VOYAGE_FUTUR_ID_VOYAGEUR+ "INTEGER);";

    public static String DROP_ATTRACTION_PAYS_TABLE = "drop table if exists + " + COMPAGNON_VOYAGE_FUTUR_TABLE;

    public static String queryGetAll = "select * from " + COMPAGNON_VOYAGE_FUTUR_TABLE;



    private static ArrayList<CompagnonVoyageFutur> listeCompagnon;

    public static void init(){
        listeCompagnon = new ArrayList<>();
        listeCompagnon.add(new CompagnonVoyageFutur(10, 10));
        listeCompagnon.add(new CompagnonVoyageFutur(20, 20));
        listeCompagnon.add(new CompagnonVoyageFutur(30, 30));
        listeCompagnon.add(new CompagnonVoyageFutur(40, 40));

    }

    public static ArrayList<CompagnonVoyageFutur> getAll(){
        if(listeCompagnon == null)
            init();
        return listeCompagnon;
    }

    public static CompagnonVoyageFutur getByIdVoyageurCompagnon(int idCompare){
        if(listeCompagnon == null)
            init();
        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageurCompagnon() == idCompare)
                retour = c;
        }
        return  retour;
    }

    public static CompagnonVoyageFutur getByIdVoyageFutur(int idCompare){
        if(listeCompagnon == null)
            init();
        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageFutur() == idCompare)
                retour = c;
        }
        return  retour;
    }

    public static ArrayList<CompagnonVoyageFutur> getAllByIdVoyageFutur(int idCompare){
        if(listeCompagnon == null)
            init();
        ArrayList<CompagnonVoyageFutur> retour = new ArrayList<>();

        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageFutur() == idCompare)
                retour.add(c);
        }
        return  retour;
    }

}
