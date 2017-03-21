package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.LanguePays;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerLanguePays {

    public static String LANGUE_PAYS_ID_LANGUE = "idLangue";
    public static String LANGUE_PAYS_ID_PAYS = "idPays";
    public static String LANGUE_PAYS_TABLE = "languePays";

    public static String LANGUE_PAYS_TABLE_CREATE = "create table " + LANGUE_PAYS_TABLE + "(" +
            LANGUE_PAYS_ID_LANGUE + " INTEGER, " +
            LANGUE_PAYS_ID_PAYS + " INTEGER);";


    public static String DROP_LANGUE_PAYS_TABLE = "drop table if exists "+ LANGUE_PAYS_TABLE ;

    private static String queryGetAll = "select * from "+ LANGUE_PAYS_TABLE;


    private static ArrayList<LanguePays> listeLanguePays;

    public static void init(){
        listeLanguePays = new ArrayList<>();
        listeLanguePays.add(new LanguePays(10, 10));
        listeLanguePays.add(new LanguePays(20, 20));
        listeLanguePays.add(new LanguePays(30, 30));
        listeLanguePays.add(new LanguePays(40, 40));

    }

    public static ArrayList<LanguePays> getAll(){
        if(listeLanguePays == null)
            init();
        return listeLanguePays;
    }

    public static LanguePays getByIdLangue(int idCompare){
        if(listeLanguePays == null)
            init();
        LanguePays retour = null;
        for (LanguePays l :
                listeLanguePays) {
            if(l.getIdLangue() == idCompare)
                retour = l;
        }
        return  retour;
    }


    public static LanguePays getByIdPays(int idCompare){
        if(listeLanguePays == null)
            init();
        LanguePays retour = null;
        for (LanguePays l :
                listeLanguePays) {
            if(l.getIdPays() == idCompare)
                retour = l;
        }
        return  retour;
    }

    public static ArrayList<LanguePays> getAllByIdPays(int idCompare){
        if(listeLanguePays == null)
            init();
        ArrayList<LanguePays> retour = new ArrayList<>();

        for (LanguePays l :
                listeLanguePays) {
            if(l.getIdPays() == idCompare)
                retour.add(l);
        }
        return  retour;
    }

}
