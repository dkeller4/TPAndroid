package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.R;


import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerAttraction {

    private static ArrayList<Attraction> listeAttraction;


    public static void init(){
        listeAttraction = new ArrayList<>();
        listeAttraction.add(new Attraction(10, "Tour Eiffel", "Grande tour a visiter iconique", "Paris", 20, "Histoire", R.drawable.pays_france ));

    }

    public static ArrayList<Attraction> getAll(){
        if(listeAttraction == null)
            init();
        return listeAttraction;
    }

    public static Attraction getById(int idCompare){
        if(listeAttraction == null)
            init();
        Attraction retour = null;
        for (Attraction a :
                listeAttraction) {
            if(a.getIdAttraction() == idCompare)
                retour = a;
        }
        return  retour;
    }


}
