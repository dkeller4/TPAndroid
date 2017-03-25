package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

    private final String id = "xczvxcvdwerfrsdfs";
    SharedPreferences pref;
    int idVoyageur;
    Voyageur leVoyageur;
    Context ctx;

    ImageView pu_img_utilisateur;
    TextView pu_tv_nom, pu_tv_categorie, pu_tv_age, pu_tv_sexe, pu_tv_pays, pu_tv_listeLangue, pu_tv_listePreference;
    Button pu_btn_listeVoyageFutur, pu_btn_ajoutVoyageFutur, pu_btn_ajoutVoyagePasse;
    Date dateAuj, dateNaiss;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_utilisateur);

        ctx = this;

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        idVoyageur = pref.getInt(id,-1);
        leVoyageur = new Voyageur();
        leVoyageur = ManagerVoyageur.getById(this, idVoyageur);

        String name = leVoyageur.getRessImgProfil();
        int imgIdressource = getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");

        pu_img_utilisateur = (ImageView) findViewById(R.id.pu_img_utilisateur);
        pu_img_utilisateur.setImageResource(imgIdressource);

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
        langue = ManagerLangueVoyageur.getAllByIdVoyageur(this, idVoyageur);
        int nbLangues = langue.size();
        String lesLangues = null;
        if (nbLangues ==1) lesLangues = ManagerLangue.getById(this, langue.get(0).getIdLangue()).getLangue();
        if (nbLangues ==2) lesLangues = (ManagerLangue.getById(this, langue.get(0).getIdLangue()).getLangue() + ", "
                + ManagerLangue.getById(this, langue.get(1).getIdLangue()).getLangue());
        if (nbLangues ==3) lesLangues = ManagerLangue.getById(this, langue.get(0).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(this, langue.get(1).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(this, langue.get(2).getIdLangue()).getLangue();

        pu_tv_listeLangue.setText(lesLangues);

        pu_tv_listePreference = (TextView) findViewById(R.id.pu_listePreference);
        ArrayList<PreferenceVoyageur> preference = new ArrayList<>();
        preference = ManagerPreferenceVoyageur.getAllByIdVoyageur(this, idVoyageur);
        int nbPreferences = preference.size();
        String lesPreferences = null;
        if ( nbPreferences ==1) lesPreferences = ManagerPreference.getById(this, preference.get(0).getIdPreference()).getType();
        if ( nbPreferences ==2) lesPreferences = (ManagerPreference.getById(this, preference.get(0).getIdPreference()).getType() + ", "
                + ManagerPreference.getById(this, preference.get(1).getIdPreference()).getType());
        if ( nbPreferences ==3) lesPreferences = ManagerPreference.getById(this, preference.get(0).getIdPreference()).getType()+ ", "
                + ManagerPreference.getById(this, preference.get(1).getIdPreference()).getType()+ ", "
                + ManagerPreference.getById(this, preference.get(2).getIdPreference()).getType();

        pu_tv_listePreference.setText(lesPreferences);


        pu_btn_ajoutVoyageFutur = (Button) findViewById(R.id.pu_btn_ajoutVoyageFutur);
        pu_btn_ajoutVoyagePasse = (Button) findViewById(R.id.pu_btn_ajoutVoyagePasse);
        pu_btn_listeVoyageFutur = (Button) findViewById(R.id.pu_btn_listeVoyageFutur);

        pu_btn_ajoutVoyageFutur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilUtilisateur.this, AjoutVoyageFutur.class);
                startActivity(intent);
            }
        });

        pu_btn_ajoutVoyagePasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilUtilisateur.this, AjoutVoyagePasse.class);
                startActivity(intent);
            }
        });

        pu_btn_listeVoyageFutur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilUtilisateur.this, MesVoyagesFuturs.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mon_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        intent = new Intent(getBaseContext(), MenuPrincipal.class);

        switch (item.getItemId()){
            case R.id.menu_versMenu:
                intent = new Intent(getBaseContext(), MenuPrincipal.class);
                break;
            case R.id.menu_versProfilUtilisateur:
                intent = new Intent(getBaseContext(), ProfilUtilisateur.class);
                break;
            case R.id.menu_versBrowsePays:
                intent = new Intent(getBaseContext(), BrowseListePays.class);
                break;
            case R.id.menu_versBrowseVoyageur:
                intent = new Intent(getBaseContext(), BrowseListeVoyageur.class);
                break;
            case R.id.menu_versSelecteurDestination:
                intent = new Intent(getBaseContext(), SelecteurDeDestination.class);
                break;
        }
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

}
