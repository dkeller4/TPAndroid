package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPays {



    private static ArrayList<Pays> listePays;

    public static void init(){
        listePays = new ArrayList<>();
        listePays.add(new Pays(10, "Canada", 33000000, "Amérique du Nord", R.drawable.drap_canada, R.drawable.pays_canada, ManagerLanguePays.getAll(), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));
        listePays.add(new Pays(10, "France", 33000000, "Europe", R.drawable.drap_france, R.drawable.pays_france, ManagerLanguePays.getAll(), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));
        listePays.add(new Pays(10, "Japon", 33000000, "Asie", R.drawable.drap_japan, R.drawable.pays_japon, ManagerLanguePays.getAll(), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));
        listePays.add(new Pays(10, "Brésil", 33000000, "Amérique du Sud", R.drawable.drap_brazil, R.drawable.pays_bresil, ManagerLanguePays.getAll(), ManagerPreferencePays.getAll(), ManagerAttractionPays.getAll() ));

    }

    public static ArrayList<Pays> getAll(){
        if(listePays == null)
            init();
        return listePays;
    }

    public static Pays getById(int idCompare){
        Pays retour = null;
        for (Pays p :
                listePays) {
            if(p.getIdPays() == idCompare)
                retour = p;
        }
        return  retour;
    }


}
