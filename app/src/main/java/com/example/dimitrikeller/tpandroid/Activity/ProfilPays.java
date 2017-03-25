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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Adapter.ListeAttractionAdapter;
import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Entite.AttractionPays;
import com.example.dimitrikeller.tpandroid.Entite.LanguePays;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.Preference;
import com.example.dimitrikeller.tpandroid.Entite.PreferencePays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerAttraction;
import com.example.dimitrikeller.tpandroid.Manager.ManagerAttractionPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangue;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreference;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ProfilPays extends AppCompatActivity {

    Intent intentRetour, intent;
    int idPays;
    Context ctx;
    Pays lePays;

    TextView tv_nom, tv_contient, tv_population, tv_capitale, tv_devise, tv_langues, tv_preferences;
    ImageView img;
    ListView lv;
    List<Attraction> lesAttractions;
    Button btn_planifier;

    int imgIdressource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_pays);

        ctx=this;

        intentRetour = getIntent();
        idPays = intentRetour.getIntExtra("idPays", -1);
        lePays = ManagerPays.getById(ctx, idPays);


        tv_nom = (TextView) findViewById(R.id.pp_nom);
        tv_contient = (TextView) findViewById(R.id.pp_tv_continent);
        tv_population = (TextView) findViewById(R.id.pp_tv_population);
        tv_capitale = (TextView) findViewById(R.id.pp_tv_capitale);
        tv_devise= (TextView) findViewById(R.id.pp_tv_devises);
        tv_langues = (TextView) findViewById(R.id.pp_tv_langues);
        tv_preferences = (TextView) findViewById(R.id.pp_tv_preferences);
        lv = (ListView) findViewById(R.id.pp_lv);
        img = (ImageView) findViewById(R.id.pp_img);
        btn_planifier = (Button) findViewById(R.id.pp_btn_planifier);

        tv_nom.setText(lePays.getNom());

        String name = lePays.getRessImgPays();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");
        img.setImageResource(imgIdressource);

        tv_contient.setText(lePays.getContinent());
        tv_population.setText("" + lePays.getPopulation() + " habitants");
        tv_capitale.setText("Capitale: " + lePays.getCapitale());
        tv_devise.setText("Devise: " + lePays.getDevise());

        ArrayList<LanguePays> langue = lePays.getListeLanguePays();
        int nbLangues = langue.size();
        String lesLangues = null;
        if (nbLangues ==1) lesLangues = ManagerLangue.getById(ctx, langue.get(0).getIdLangue()).getLangue();
        if (nbLangues ==2) lesLangues = (ManagerLangue.getById(ctx, langue.get(0).getIdLangue()).getLangue() + ", "
                + ManagerLangue.getById(ctx, langue.get(1).getIdLangue()).getLangue());
        if (nbLangues ==3) lesLangues = ManagerLangue.getById(ctx, langue.get(0).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(ctx, langue.get(1).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(ctx, langue.get(2).getIdLangue()).getLangue();
        tv_langues.setText("Langues: " + lesLangues);


        ArrayList<PreferencePays> preference = lePays.getListePreferencePays();
        int nbPreferences = preference.size();
        String lesPreferences = null;
        if (nbPreferences ==1) lesPreferences = ManagerPreference.getById(ctx, preference.get(0).getIdPreference()).getType();
        if (nbPreferences ==2) lesPreferences = (ManagerPreference.getById(ctx, preference.get(0).getIdPreference()).getType() + ", "
                + ManagerPreference.getById(ctx, preference.get(1).getIdPreference()).getType());
        if (nbPreferences ==3) lesPreferences = ManagerPreference.getById(ctx, preference.get(0).getIdPreference()).getType()+ ", "
                + ManagerPreference.getById(ctx, preference.get(1).getIdPreference()).getType()+ ", "
                + ManagerPreference.getById(ctx, preference.get(2).getIdPreference()).getType();
        tv_preferences.setText("Preferences: " + lesPreferences);


        btn_planifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilPays.this, AjoutVoyageFutur.class);
                startActivity(intent);
            }
        });


        ArrayList<AttractionPays> lesAttPays = new ArrayList<>();
        lesAttPays = ManagerAttractionPays.getAllByIdPays(ctx,idPays);
        Attraction att;
        lesAttractions= new ArrayList<>();
        for (AttractionPays ap: lesAttPays){
            att = ManagerAttraction.getById(ctx, ap.getIdAttraction());
            lesAttractions.add(att);
        }





        ListeAttractionAdapter attAdap = new ListeAttractionAdapter(ctx, R.layout.vue_perso_liste_attraction, lesAttractions);
        lv.setAdapter(attAdap);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idAttraction = lesAttractions.get(position).getIdAttraction();
                Intent intent = new Intent(ProfilPays.this, ProfilAttraction.class);
                intent.putExtra("idAttraction", idAttraction);
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
