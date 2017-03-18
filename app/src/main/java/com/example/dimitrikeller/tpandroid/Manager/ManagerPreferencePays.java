package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.LanguePays;
import com.example.dimitrikeller.tpandroid.Entite.PreferencePays;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPreferencePays {

    private static ArrayList<PreferencePays> listePreferencePays;

    public static void init(){
        listePreferencePays = new ArrayList<>();
        listePreferencePays.add(new PreferencePays(10, 10));
        listePreferencePays.add(new PreferencePays(20, 20));
        listePreferencePays.add(new PreferencePays(30, 30));
        listePreferencePays.add(new PreferencePays(40, 40));

    }

    public static ArrayList<PreferencePays> getAll(){
        if(listePreferencePays == null)
            init();
        return listePreferencePays;
    }

    public static PreferencePays getByIdPreference(int idCompare){
        if(listePreferencePays == null)
            init();
        PreferencePays retour = null;
        for (PreferencePays p :
                listePreferencePays) {
            if(p.getIdPreference() == idCompare)
                retour = p;
        }
        return  retour;
    }


    public static PreferencePays getByIdPays(int idCompare){
        if(listePreferencePays == null)
            init();
        PreferencePays retour = null;
        for (PreferencePays p :
                listePreferencePays) {
            if(p.getIdPays() == idCompare)
                retour = p;
        }
        return  retour;
    }

    public static ArrayList<PreferencePays> getAllByIdPays(int idCompare){
        if(listePreferencePays == null)
            init();
        ArrayList<PreferencePays> retour = new ArrayList<>();

        for (PreferencePays p :
                listePreferencePays) {
            if(p.getIdPays() == idCompare)
                retour.add(p);
        }
        return  retour;
    }

}
