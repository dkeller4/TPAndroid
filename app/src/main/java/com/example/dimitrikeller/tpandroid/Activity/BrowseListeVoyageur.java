package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dimitrikeller.tpandroid.Adapter.ListeBrowseVoyageurAdapter;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

public class BrowseListeVoyageur extends AppCompatActivity {

    Context ctx;
    ListeBrowseVoyageurAdapter voyAdapt;
    ListView lv;
    List<Voyageur> lesVoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_liste_voyageur);

        ctx = this;

        lv = (ListView) findViewById(R.id.listeVoyageur_lv);

        lesVoy = ManagerVoyageur.getAll(ctx);
        voyAdapt = new ListeBrowseVoyageurAdapter(ctx, R.layout.vue_perso_liste_voyageurs, lesVoy);
        lv.setAdapter(voyAdapt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int idVoy = lesVoy.get(position).getIdVoyageur();

                Intent intent = new Intent(BrowseListeVoyageur.this, ProfilAutreVoyageur.class);
                intent.putExtra("idVoyageur", idVoy);
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
