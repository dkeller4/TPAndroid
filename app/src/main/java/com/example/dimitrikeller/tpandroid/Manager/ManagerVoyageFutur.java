package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerVoyageFutur {

    private static ArrayList<VoyageFutur> listeVoyageFutur;

    public static void init(){
        listeVoyageFutur = new ArrayList<>();
        listeVoyageFutur.add(new VoyageFutur(10, 10, 10, "31/12/2016", "30/01/2017", true, false, ManagerCompagnonVoyageFutur.getAll()));
        listeVoyageFutur.add(new VoyageFutur(10, 20, 20, "31/12/2016", "30/01/2017", true, false, ManagerCompagnonVoyageFutur.getAll()));
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
