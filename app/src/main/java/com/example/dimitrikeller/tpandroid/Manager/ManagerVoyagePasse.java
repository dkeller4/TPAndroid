package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.VoyagePasse;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerVoyagePasse {

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

    public static VoyagePasse getById(int idCompare){
        VoyagePasse retour = null;
        for (VoyagePasse v :
                listeVoyagePasse) {
            if(v.getIdVoyage() == idCompare)
                retour = v;
        }
        return  retour;
    }

}
