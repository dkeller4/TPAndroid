package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.VoyagePasse;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyagePasse;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.Adapter.ListePaysDrapeauxAdapter;

import java.util.ArrayList;
import java.util.List;

public class AjoutVoyagePasse extends AppCompatActivity {
    private final String id = "xczvxcvdwerfrsdfs";
    SharedPreferences pref;
    int idVoyageur;

    Spinner spinner;
    GridView gv;
    Context ctx;
    int wScreen;
    String regionSelect;
    List<Pays> lesPays;
    List<Pays> lesPaysSelect;
    ListePaysDrapeauxAdapter adaptGv;
    Button btn_ajout;
    ArrayList<VoyagePasse> paysVisite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_voyage_passe);
        ctx = this;


        pref = PreferenceManager.getDefaultSharedPreferences(this);
        idVoyageur = pref.getInt(id,-1);

        wScreen = getResources().getDisplayMetrics().widthPixels;
        regionSelect = "Monde";

        btn_ajout = (Button) findViewById(R.id.avp_ajouter_voyage);

        //Ajout du Spinner
        spinner = (Spinner) findViewById(R.id.ajout_voyage_paasse_spinner);

        String [] listeRegion = getResources().getStringArray(R.array.listeRegionMonde);
        SpinnerAdapter spinAdapt = new ArrayAdapter<String>(ctx,android.R.layout.simple_list_item_1,listeRegion);
        spinner.setAdapter(spinAdapt);


        //Ajout du GridView
        gv= (GridView) findViewById(R.id.ajout_voyage_passe_drapeaux);
        gv.setColumnWidth(wScreen/3);
        lesPays = ManagerPays.getAll(this);
        lesPaysSelect = lesPays;
        adaptGv = new ListePaysDrapeauxAdapter(ctx, R.layout.vue_perso_ajout_voyage_passe,lesPays);
        gv.setAdapter(adaptGv);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                regionSelect= parent.getSelectedItem().toString();
                Log.d("Debug", regionSelect);
                if (!regionSelect.equals("Monde")) {

                    lesPaysSelect = new ArrayList<Pays>();

                    for (Pays p : lesPays) {

                        if (regionSelect.equals(p.getContinent())) {
                            lesPaysSelect.add(p);
                        }
                    }
                    adaptGv = new ListePaysDrapeauxAdapter(ctx, R.layout.vue_perso_ajout_voyage_passe, lesPaysSelect);
                    gv.setAdapter(adaptGv);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                view.setBackgroundColor(Color.BLUE);
                view.invalidate();

                paysVisite = new ArrayList<>();
                int pays= lesPaysSelect.get(position).getIdPays();
                VoyagePasse vp = new VoyagePasse();
                vp.setIdVoyageur(idVoyageur);
                vp.setIdPays(pays);
                paysVisite.add(vp);

            }
        });

        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (paysVisite !=null) {
                    for (VoyagePasse vp : paysVisite) {
                        ManagerVoyagePasse.add(vp, ctx);
                    }

                    ArrayList<VoyagePasse> voyageUtilisateur = ManagerVoyagePasse.getAllByIdVoyageur(ctx, idVoyageur);

                    int cpt = 1;

                    for (VoyagePasse vp : voyageUtilisateur) {
                        cpt++;
                    }
                    Log.d("Debug", "" + cpt);
                    Voyageur voy = new Voyageur();
                    voy = ManagerVoyageur.getById(ctx, idVoyageur);


                    if (cpt >= 5)
                        voy.setCategorieVoyageur("Explorateur en devenir");
                    if (cpt >= 10)
                        voy.setCategorieVoyageur("Petit Explorateur");
                    if (cpt >= 20)
                        voy.setCategorieVoyageur("Grand Explorateur");
                    if (cpt >= 50)
                        voy.setCategorieVoyageur("GlobeTrotter");
                    if (cpt >= 100)
                        voy.setCategorieVoyageur("Citoyen du monde");

                    Log.d("Debug", voy.getCategorieVoyageur());
                    ManagerVoyageur.update(voy, ctx);
                }
                Intent intent = new Intent(AjoutVoyagePasse.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
