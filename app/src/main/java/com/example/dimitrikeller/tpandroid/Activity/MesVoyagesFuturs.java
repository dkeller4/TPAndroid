package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Adapter.ListeVoyageFuturAdapter;
import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageFutur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

public class MesVoyagesFuturs extends AppCompatActivity {
    private final String id = "xczvxcvdwerfrsdfs";
    SharedPreferences pref;
    Context ctx;
    int idVoyageur;
    ListView lv;
    TextView mvf_tv_vide;
    Button mvf_btn_compas, mvf_btn_ajout, mvf_btn_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_voyages_futurs);
ctx = this;
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        idVoyageur = pref.getInt(id,-1);

        lv = (ListView) findViewById(R.id.mvf_listView);

        List<VoyageFutur> vf = ManagerVoyageFutur.getAllByIdVoyageur(ctx,idVoyageur);

        if(vf.size()>0) {
            mvf_tv_vide = (TextView) findViewById(R.id.mvf_tv_vide);
            mvf_tv_vide.setText("");
            ListeVoyageFuturAdapter lvfadap = new ListeVoyageFuturAdapter(ctx, R.layout.vue_perso_liste_voyage_futur, vf);
            lv.setAdapter(lvfadap);
        }

        mvf_btn_compas = (Button) findViewById(R.id.mvf_btn_compas);
        mvf_btn_ajout = (Button) findViewById(R.id.mvf_btn_ajout);
        mvf_btn_retour = (Button) findViewById(R.id.mvf_btn_retour);

        mvf_btn_compas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MesVoyagesFuturs.this, SelecteurDeDestination.class);
                startActivity(intent);
            }
        });

        mvf_btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MesVoyagesFuturs.this, AjoutVoyageFutur.class);
                startActivity(intent);
            }
        });

        mvf_btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MesVoyagesFuturs.this, ProfilUtilisateur.class);
                startActivity(intent);
            }
        });

    }
}
