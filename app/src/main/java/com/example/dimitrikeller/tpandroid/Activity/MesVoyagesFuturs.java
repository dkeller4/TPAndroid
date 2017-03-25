package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        }

        ListeVoyageFuturAdapter lvfadap = new ListeVoyageFuturAdapter(ctx, R.layout.vue_perso_liste_voyage_futur, vf);
        lv.setAdapter(lvfadap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });


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
