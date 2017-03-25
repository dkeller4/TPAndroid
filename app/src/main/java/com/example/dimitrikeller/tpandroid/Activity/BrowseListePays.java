package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Adapter.ListeBrowsePaysAdapter;
import com.example.dimitrikeller.tpandroid.Adapter.ListeVoyageFuturAdapter;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageFutur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

public class BrowseListePays extends AppCompatActivity {

    ListView lv;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_liste_pays);
        ctx=this;
        lv= (ListView) findViewById(R.id.blp_lv);

        final List<Pays> lesPays = ManagerPays.getAll(ctx);

        ListeBrowsePaysAdapter blpadap = new ListeBrowsePaysAdapter(ctx, R.layout.vue_perso_petit_pays, lesPays);
        lv.setAdapter(blpadap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idPays = lesPays.get(position).getIdPays();
                Log.d("DebugIdPays", "" + idPays);
                Intent intent = new Intent(BrowseListePays.this, ProfilPays.class);
                intent.putExtra("idPays", idPays);
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
