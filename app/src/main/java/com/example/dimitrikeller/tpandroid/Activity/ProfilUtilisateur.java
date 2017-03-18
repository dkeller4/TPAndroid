package com.example.dimitrikeller.tpandroid.Activity;

import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.Preference;
import com.example.dimitrikeller.tpandroid.Entite.PreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangue;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangueVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreference;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ProfilUtilisateur extends AppCompatActivity {

    Voyageur leVoyageur;
    int idVoyageur;
    ImageView pu_img_utilisateur;
    TextView pu_tv_nom, pu_tv_categorie, pu_tv_age, pu_tv_sexe, pu_tv_pays, pu_tv_listeLangue, pu_tv_listePreference;
    Button pu_btn_listeVoyageFutur, pu_btn_ajoutVoyageFutur, pu_btn_ajoutVoyagePasse;
    Date dateAuj;
    Date dateNaiss;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_utilisateur);

        idVoyageur = 30;
        leVoyageur = new Voyageur();
        leVoyageur = ManagerVoyageur.getById(idVoyageur);

        pu_img_utilisateur = (ImageView) findViewById(R.id.pu_img_utilisateur);
        pu_img_utilisateur.setImageResource(leVoyageur.getRessImgProfil());

        pu_tv_categorie = (TextView) findViewById(R.id.pu_tv_catégorie);
        pu_tv_categorie.setText(leVoyageur.getCategorieVoyageur());

        pu_tv_nom = (TextView) findViewById(R.id.pu_tv_nom);
        pu_tv_nom.setText("Nom: " + leVoyageur.getPenom() + " "+ leVoyageur.getNom());

        pu_tv_age = (TextView) findViewById(R.id.pu_tv_age);
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dateAuj = dates.parse(timeStamp);
            dateNaiss = dates.parse(leVoyageur.getDateNaissance());
            long difference = dateAuj.getTime()-dateNaiss.getTime();
            age = (int) (difference / (365.25 * 24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pu_tv_age.setText( "Âge: " + age + "ans");

        pu_tv_sexe = (TextView) findViewById(R.id.pu_tv_sexe);
        if (leVoyageur.getSexe().equals("f")){
            pu_tv_sexe.setText("Femme");
        }
        if (leVoyageur.getSexe().equals("h")){
            pu_tv_sexe.setText("Homme");
        }

        pu_tv_pays = (TextView) findViewById(R.id.pu_tv_pays);
        pu_tv_pays.setText("Pays d'origine: " + leVoyageur.getPaysNaissance());

        pu_tv_listeLangue = (TextView) findViewById(R.id.pu_listeLangue);
        ArrayList<LangueVoyageur> langue = new ArrayList<>();
        langue = ManagerLangueVoyageur.getAllByIdVoyageur(idVoyageur);
        int nbLangues = langue.size();
        String lesLangues = null;
        if (nbLangues ==1) lesLangues = ManagerLangue.getById(langue.get(0).getIdLangue()).getLangue();
        if (nbLangues ==2) lesLangues = (ManagerLangue.getById(langue.get(0).getIdLangue()).getLangue() + ", "
                + ManagerLangue.getById(langue.get(1).getIdLangue()).getLangue());
        if (nbLangues ==3) lesLangues = ManagerLangue.getById(langue.get(0).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(langue.get(1).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(langue.get(2).getIdLangue()).getLangue();

        pu_tv_listeLangue.setText(lesLangues);

        pu_tv_listePreference = (TextView) findViewById(R.id.pu_listePreference);
        ArrayList<PreferenceVoyageur> preference = new ArrayList<>();
        preference = ManagerPreferenceVoyageur.getAllByIdVoyageur(idVoyageur);
        int nbPreferences = preference.size();
        String lesPreferences = null;
        if ( nbPreferences ==1) lesPreferences = ManagerPreference.getById(preference.get(0).getIdPreference()).getType();
        if ( nbPreferences ==2) lesPreferences = (ManagerPreference.getById(preference.get(0).getIdPreference()).getType() + ", "
                + ManagerPreference.getById(preference.get(1).getIdPreference()).getType());
        if ( nbPreferences ==3) lesPreferences = ManagerPreference.getById(preference.get(0).getIdPreference()).getType()+ ", "
                + ManagerPreference.getById(preference.get(1).getIdPreference()).getType()+ ", "
                + ManagerPreference.getById(preference.get(2).getIdPreference()).getType();

        pu_tv_listePreference.setText(lesPreferences);


        pu_btn_ajoutVoyageFutur = (Button) findViewById(R.id.pu_btn_ajoutVoyageFutur);
        pu_btn_ajoutVoyagePasse = (Button) findViewById(R.id.pu_btn_ajoutVoyagePasse);
        pu_btn_listeVoyageFutur = (Button) findViewById(R.id.pu_btn_listeVoyageFutur);


    }
}
