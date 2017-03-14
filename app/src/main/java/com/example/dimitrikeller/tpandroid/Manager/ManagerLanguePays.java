package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.LanguePays;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerLanguePays {

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

    public static LanguePays getById(int idCompare){
        LanguePays retour = null;
        for (LanguePays l :
                listeLanguePays) {
            if(l.getIdLangue() == idCompare)
                retour = l;
        }
        return  retour;
    }

}
