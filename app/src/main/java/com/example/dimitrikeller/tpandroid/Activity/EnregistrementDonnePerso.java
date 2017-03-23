package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dimitrikeller.tpandroid.Adapter.ListeImageProfilSelectionAdapter;
import com.example.dimitrikeller.tpandroid.Entite.ImageProfil;
import com.example.dimitrikeller.tpandroid.Entite.Langue;
import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.Preference;
import com.example.dimitrikeller.tpandroid.Entite.PreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerImageProfil;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangue;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangueVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreference;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;
import java.util.List;

public class EnregistrementDonnePerso extends AppCompatActivity {

    private final String id = "xczvxcvdwerfrsdfs";
    SharedPreferences pref;
    int idVoyageur;

    Button btn_suivant, btn_langue, btn_preference;
    EditText ed_prenom, ed_nom;
    AutoCompleteTextView paysOrigine;
    DatePicker dateNaissance;
    RadioButton femme, homme;
    List<Pays> lesPays;
    String[] listeNomPays;
    ArrayList<Langue> lesLangues;
    ArrayList<Preference> lesPreferences;
Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement_donne_perso);

        ctx=this;

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        idVoyageur = pref.getInt(id,-1);

        btn_suivant = (Button) findViewById(R.id.edp_btn_suivant);
        ed_prenom = (EditText) findViewById(R.id.edp_prenom);
        ed_nom = (EditText) findViewById(R.id.edp_nom);
        paysOrigine = (AutoCompleteTextView) findViewById(R.id.edp_pays_naissance);
        btn_langue = (Button) findViewById(R.id.edp_btn_langue);
        dateNaissance = (DatePicker) findViewById(R.id.edp_date_naissance);
        btn_preference = (Button) findViewById(R.id.edp_btn_preferences);
        femme= (RadioButton) findViewById(R.id.edp_femme);
        homme = (RadioButton) findViewById(R.id.edp_homme);



        lesPays = ManagerPays.getAll(this);
        listeNomPays = new String[lesPays.size()];
        int i = 0;
        for (Pays p: lesPays){
            listeNomPays[i]=p.getNom();
            i++;
        }
        ArrayAdapter<String> adapterPays = new ArrayAdapter<String> (ctx,android.R.layout.simple_list_item_1,listeNomPays);
        paysOrigine.setAdapter(adapterPays);

        lesLangues = ManagerLangue.getAll(ctx);

        btn_langue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Langues");
                boolean bl[] = new boolean[9];
                builder.setMultiChoiceItems(R.array.liste_langues,bl, new DialogInterface.OnMultiChoiceClickListener() {
                    int cpt =0;
                    @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        LangueVoyageur lv = new LangueVoyageur();
                        String laLangue = getResources().getStringArray(R.array.liste_langues)[which];
                        int idLangue = 0;
                        for (Langue l: lesLangues){
                            if (laLangue.equals(l.getLangue()))
                                idLangue = l.getIdLangue();
                        }
                        lv.setIdVoyageur(idVoyageur);
                        lv.setIdLangue(idLangue);
                        ManagerLangueVoyageur.add(lv, ctx);
                            }});

                builder.setPositiveButton("Soumettre", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        lesPreferences = ManagerPreference.getAll(ctx);

        btn_preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Préférences");
                boolean bl[] = new boolean[6];
                builder.setMultiChoiceItems(R.array.liste_preferences,bl, new DialogInterface.OnMultiChoiceClickListener() {
                    int cpt =0;
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        PreferenceVoyageur pv = new PreferenceVoyageur();
                        String laPreference = getResources().getStringArray(R.array.liste_preferences)[which];
                        int idPreference = 0;
                        for (Preference p: lesPreferences){
                            if (laPreference.equals(p.getType()))
                                idPreference = p.getIdPreference();
                        }
                        pv.setIdVoyageur(idVoyageur);
                        pv.setIdPreference(idPreference);
                        ManagerPreferenceVoyageur.add(pv, ctx);
                    }});

                builder.setPositiveButton("Soumettre", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        btn_suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int day = dateNaissance.getDayOfMonth();
                int month= dateNaissance.getMonth()+1;
                int year = dateNaissance.getYear();
                final String date = ""+day+"/"+month+"/"+year;
                Log.d("debug", date);

                Voyageur voy = new Voyageur();
                voy.setIdVoyageur(idVoyageur);
                voy.setNom(ed_nom.getText().toString());
                voy.setPenom(ed_prenom.getText().toString());
                voy.setDateNaissance(date);
                voy.setPaysNaissance(paysOrigine.getText().toString());
                if (femme.isChecked()){
                    voy.setSexe("f");
                }
                else{
                    voy.setSexe("h");
                }
                voy.setCategorieVoyageur("Débutant");
                voy.setRessImgProfil("pr_pika");
                ManagerVoyageur.add(voy, ctx);

                Intent intent = new Intent(EnregistrementDonnePerso.this, ChoixImageProfil.class);
                startActivity(intent);
            }
        });

    }
}
