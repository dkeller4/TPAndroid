package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.Adapter.ListePaysDrapeauxAdapter;

import java.util.ArrayList;
import java.util.List;

public class Ajout_voyage_passe extends AppCompatActivity {

    Spinner spinner;
    GridView gv;
    Context ctx;
    int wScreen;
    String regionSelect;
    List<Pays> lesPays;
    List<Pays> lesPaysSelect;
    ListePaysDrapeauxAdapter adaptGv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_voyage_passe);
        ctx = this;
        wScreen = getResources().getDisplayMetrics().widthPixels;
        regionSelect = "Monde";

        //Ajout du Spinner
        spinner = (Spinner) findViewById(R.id.ajout_voyage_paasse_spinner);

        String [] listeRegion = getResources().getStringArray(R.array.listeRegionMonde);
        SpinnerAdapter spinAdapt = new ArrayAdapter<String>(ctx,android.R.layout.simple_list_item_1,listeRegion);
        spinner.setAdapter(spinAdapt);


        //Ajout du GridView
        gv= (GridView) findViewById(R.id.ajout_voyage_passe_drapeaux);
        gv.setColumnWidth(wScreen/3);
        lesPays = ManagerPays.getAll();
        lesPaysSelect = new ArrayList<Pays>();
        adaptGv = new ListePaysDrapeauxAdapter(ctx, R.layout.vue_perso_ajout_voyage_passe,lesPays);
        gv.setAdapter(adaptGv);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                regionSelect= parent.getSelectedItem().toString();
                if (!regionSelect.equals("Monde")) {
                    adaptGv.clear();
                    lesPaysSelect.clear();

                    for (Pays p : lesPays) {

                        if (regionSelect.equals(p.getContinent())) {
                            lesPaysSelect.add(p);
                        }
                    }
                    adaptGv.addAll(lesPaysSelect);
                    gv.invalidate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.setBackgroundColor(Color.BLUE);
                view.invalidate();
            }
        });
    }
}
