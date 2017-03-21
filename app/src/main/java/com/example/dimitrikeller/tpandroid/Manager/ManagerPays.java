package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPays {

    public static String PAYS_ID = "idPays";
    public static String PAYS_NOM = "nom";
    public static String PAYS_POPULATION = "population";
    public static String PAYS_CONTINENT = "continent";
    public static String PAYS_CAPITALE = "capitale";
    public static String PAYS_DEVISE = "devise";
    public static String PAYS_IMG_DRAPEAU = "imgDrapeau";
    public static String PAYS_IMG_PAYS ="imgPays";
    public static String PAYS_TABLE = "pays";

    public static String PAYS_TABLE_CREATE = "create table " + PAYS_TABLE + "(" +
            PAYS_ID + " INTEGER PRIMARY KEY, " +
            PAYS_NOM + " TEXT, " +
            PAYS_POPULATION + " INTEGER, " +
            PAYS_CONTINENT + " TEXT, "+
            PAYS_CAPITALE +  " TEXT, "+
            PAYS_DEVISE + " TEXT, "+
            PAYS_IMG_DRAPEAU + " TEXT, "+
            PAYS_IMG_PAYS + " TEXT);";


    public static String DROP_PAYS_TABLE = "drop table if exists "+ PAYS_TABLE ;

    private static String queryGetAll = "select * from "+ PAYS_TABLE;

    private static ArrayList<Pays> listePays;

    public static void init(){
        listePays = new ArrayList<>();
        listePays.add(new Pays(10, "Canada", 33000000, "Amérique du Nord", "Ottawa", "Dollar", R.drawable.drap_canada, R.drawable.pays_canada, ManagerLanguePays.getAllByIdPays(10), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));
        listePays.add(new Pays(20, "France", 33000000, "Europe", "Paris", "Euro",R.drawable.drap_france, R.drawable.pays_france, ManagerLanguePays.getAll(), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));
        listePays.add(new Pays(30, "Japon", 33000000, "Asie", "Tokyo", "Yen", R.drawable.drap_japan, R.drawable.pays_japon, ManagerLanguePays.getAll(), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));
        listePays.add(new Pays(40, "Brésil", 33000000, "Amérique du Sud", "Brasilia", "Réal", R.drawable.drap_brazil, R.drawable.pays_bresil, ManagerLanguePays.getAll(), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));

    }

    public static ArrayList<Pays> getAll(){
        if(listePays == null)
            init();
        return listePays;
    }

    public static Pays getById(int idCompare){

        Pays retour = null;
        if(listePays == null)
            init();

        for (Pays p :
                listePays) {
            if(p.getIdPays() == idCompare)
                retour = p;
        }
        return  retour;
    }


}
