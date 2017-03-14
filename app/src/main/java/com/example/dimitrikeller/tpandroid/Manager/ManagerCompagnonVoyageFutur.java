package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.CompagnonVoyageFutur;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerCompagnonVoyageFutur {


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
        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageurCompagnon() == idCompare)
                retour = c;
        }
        return  retour;
    }

    public static CompagnonVoyageFutur getByIdVoyageFutur(int idCompare){
        CompagnonVoyageFutur retour = null;
        for (CompagnonVoyageFutur c :
                listeCompagnon) {
            if(c.getIdVoyageFutur() == idCompare)
                retour = c;
        }
        return  retour;
    }


}
