package com.example.dimitrikeller.tpandroid.Manager;


import com.example.dimitrikeller.tpandroid.Entite.AttractionPays;


import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerAttractionPays {

    private static ArrayList<AttractionPays> listeAttraction;

    public static void init(){
        listeAttraction = new ArrayList<>();
        listeAttraction.add(new AttractionPays(10, 10));
        listeAttraction.add(new AttractionPays(20, 20));
        listeAttraction.add(new AttractionPays(30, 30));
        listeAttraction.add(new AttractionPays(40, 40));

    }

    public static ArrayList<AttractionPays> getAll(){
        if(listeAttraction == null)
            init();
        return listeAttraction;
    }

    public static AttractionPays getByIdAttraction(int idCompare){
        if(listeAttraction == null)
            init();
        AttractionPays retour = null;
        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdAttraction() == idCompare)
                retour = a;
        }
        return  retour;
    }

    public static AttractionPays getByIdPays(int idCompare){
        if(listeAttraction == null)
            init();
        AttractionPays retour = null;
        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdPays() == idCompare)
                retour = a;
        }
        return  retour;
    }

    public static ArrayList<AttractionPays> getAllByIdPays(int idCompare){
        if(listeAttraction == null)
            init();
        ArrayList<AttractionPays> retour = new ArrayList<>();

        for (AttractionPays a :
                listeAttraction) {
            if(a.getIdPays() == idCompare)
                retour.add(a);
        }
        return  retour;
    }

}
