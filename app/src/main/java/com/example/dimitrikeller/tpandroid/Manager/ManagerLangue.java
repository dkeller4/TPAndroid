package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.Langue;
import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerLangue {

    private static ArrayList<Langue> listeLangue;

    public static void init(){
        listeLangue = new ArrayList<>();
        listeLangue.add(new Langue(10, "Français"));
        listeLangue.add(new Langue(20, "Anglais"));
        listeLangue.add(new Langue(30, "Néerlandais"));
        listeLangue.add(new Langue(40, "Espagnol"));

    }

    public static ArrayList<Langue> getAll(){
        if(listeLangue == null)
            init();
        return listeLangue;
    }

    public static Langue getById(int idCompare){
        if(listeLangue == null)
            init();

        Langue retour = null;
        for (Langue l :
                listeLangue) {
            if(l.getIdLangue() == idCompare)
                retour = l;
        }
        return  retour;
    }


}
