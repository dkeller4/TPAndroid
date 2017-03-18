package com.example.dimitrikeller.tpandroid.Manager;

import com.example.dimitrikeller.tpandroid.Entite.InvitationVoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.Pays;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-18.
 */

public class ManagerInvitationVoyageFutur {


    private static ArrayList<InvitationVoyageFutur> listeInvitationVoyageFutur;

    public static void init(){
        listeInvitationVoyageFutur = new ArrayList<>();
        listeInvitationVoyageFutur.add(new InvitationVoyageFutur(10,10,10,20,true,false));
        listeInvitationVoyageFutur.add(new InvitationVoyageFutur(20,20,20,10,true,false));
        listeInvitationVoyageFutur.add(new InvitationVoyageFutur(30,30,40,30,true,false));
        listeInvitationVoyageFutur.add(new InvitationVoyageFutur(40,40,30,40,true,false));

    }


    public static ArrayList<InvitationVoyageFutur> getAll(){
        if(listeInvitationVoyageFutur == null)
            init();
        return listeInvitationVoyageFutur;
    }

    public static InvitationVoyageFutur getByIdVoyageFutur(int idCompare){
        if(listeInvitationVoyageFutur == null)
            init();
        InvitationVoyageFutur retour = null;
        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageFutur() == idCompare)
                retour = v;
        }
        return  retour;
    }


    public static InvitationVoyageFutur getByIdVoyageurEnvoyeur(int idCompare){
        if(listeInvitationVoyageFutur == null)
            init();
        InvitationVoyageFutur retour = null;
        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurEnvoyeur() == idCompare)
                retour = v;
        }
        return  retour;
    }

    public static InvitationVoyageFutur getByIdVoyageurReceveur(int idCompare){
        if(listeInvitationVoyageFutur == null)
            init();
        InvitationVoyageFutur retour = null;
        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurReceveur() == idCompare)
                retour = v;
        }
        return  retour;
    }


    public static ArrayList<InvitationVoyageFutur> getAllByIdVoyageurEnvoyeur(int idCompare){
        if(listeInvitationVoyageFutur == null)
            init();
        ArrayList<InvitationVoyageFutur> retour = new ArrayList<>();

        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurEnvoyeur() == idCompare)
                retour.add(v);
        }
        return  retour;
    }

    public static ArrayList<InvitationVoyageFutur> getAllByIdVoyageurReceveur(int idCompare){
        if(listeInvitationVoyageFutur == null)
            init();
        ArrayList<InvitationVoyageFutur> retour = new ArrayList<>();

        for (InvitationVoyageFutur v :
                listeInvitationVoyageFutur) {
            if(v.getIdVoyageurReceveur() == idCompare)
                retour.add(v);
        }
        return  retour;
    }


}
