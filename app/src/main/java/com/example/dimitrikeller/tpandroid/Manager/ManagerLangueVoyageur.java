package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerLangueVoyageur {

    private static ArrayList<LangueVoyageur> listeLangueVoyageur;

    public static void init(){
        listeLangueVoyageur = new ArrayList<>();
        listeLangueVoyageur.add(new LangueVoyageur(10, 10));
        listeLangueVoyageur.add(new LangueVoyageur(20, 20));
        listeLangueVoyageur.add(new LangueVoyageur(30, 30));
        listeLangueVoyageur.add(new LangueVoyageur(40, 40));

    }

    public static ArrayList<LangueVoyageur> getAll(){
        if(listeLangueVoyageur == null)
            init();
        return listeLangueVoyageur;
    }

    public static LangueVoyageur getById(int idCompare){
        LangueVoyageur retour = null;
        for (LangueVoyageur l :
                listeLangueVoyageur) {
            if(l.getIdLangue() == idCompare)
                retour = l;
        }
        return  retour;
    }



}
