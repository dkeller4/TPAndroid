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
