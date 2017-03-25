package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageFutur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;
import java.util.List;

public class AjoutVoyageFutur extends AppCompatActivity {

    private final String id = "xczvxcvdwerfrsdfs";
    SharedPreferences pref;
    int idVoyageur;
    Context ctx;

    private AutoCompleteTextView actv;
    String[] listeNomPays;
    List<Pays> lesPays;
    Button btn_trouver, btn_ajout, btn_soumettre;
    VoyageFutur vf;
    String dateDepart, dateRetour;
    DatePicker dpDepart, dpRetour;
    CheckBox cb_flexible, cb_complet;
    int paysChoisi;
    ArrayList<VoyageFutur> listeVoyageFutur;
    int idVoyageFutur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_voyage_futur);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        idVoyageur = pref.getInt(id,-1);

        ctx = this;

        actv = (AutoCompleteTextView) findViewById(R.id.avf_autoCompleteTextView1);
        dpDepart = (DatePicker) findViewById(R.id.avf_dDepart);
        dpRetour = (DatePicker) findViewById(R.id.avf_dRetour);
        btn_ajout = (Button) findViewById(R.id.avf_btn_ajouter);
        btn_trouver = (Button) findViewById(R.id.avf_btn_trouver);
        btn_soumettre = (Button) findViewById(R.id.avf_btn_soumettre);
        cb_complet = (CheckBox) findViewById(R.id.avf_compa);
        cb_flexible = (CheckBox) findViewById(R.id.avf_flex);

        lesPays = ManagerPays.getAll(this);
        listeNomPays = new String[lesPays.size()];

        int i = 0;
        for (Pays p: lesPays){
            listeNomPays[i]=p.getNom();
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,listeNomPays);
        actv.setAdapter(adapter);





        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;

                listeVoyageFutur = ManagerVoyageFutur.getAllByIdVoyageur(ctx, idVoyageur);

                idVoyageFutur =0;

                for (VoyageFutur lvf: listeVoyageFutur){
                    idVoyageFutur = lvf.getIdVoyageFutur();
                }
                Log.d("Debug1","" +idVoyageur);
                Log.d ("Debug2", ""+ idVoyageFutur);
                intent = new Intent(AjoutVoyageFutur.this, MenuPrincipal.class);
                switch (v.getId()){
                    case R.id.avf_btn_ajouter:
                        intent = new Intent (AjoutVoyageFutur.this, AjoutCompgnonListeVoyageur.class );
                        break;
                    case R.id.avf_btn_trouver:
                        intent = new Intent(AjoutVoyageFutur.this, AjoutCompagnonParInvitation.class);
                        break;

                }
                intent.putExtra("idVoyageFutur",idVoyageFutur );
                startActivity(intent);

            }
        };

        btn_soumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lePays = actv.getText().toString();


                ArrayList<Pays> lesPays = ManagerPays.getAll(ctx);

                for (Pays p: lesPays){
                    if (p.getNom().equals(lePays))
                        paysChoisi = p.getIdPays();
                }

                int dayDep = dpDepart.getDayOfMonth();
                int monthDep = dpDepart.getMonth()+1;
                int yearDep = dpDepart.getYear();
                dateDepart = ""+dayDep+"/"+monthDep+"/"+yearDep;

                int dayRet = dpRetour.getDayOfMonth();
                int monthRet = dpRetour.getMonth()+1;
                int yearRet = dpRetour.getYear();
                dateRetour = ""+dayRet+"/"+monthRet+"/"+yearRet;

                vf = new VoyageFutur();
                vf.setIdVoyageurPrincipal(idVoyageur);
                vf.setIdPays(paysChoisi);
                vf.setDateDepart(dateDepart);
                vf.setDateRetour(dateRetour);
                if (cb_flexible.isChecked()){
                    vf.setEstFlexible(true);
                }
                else {
                    vf.setEstFlexible(false);
                }
                if (cb_complet.isChecked()){
                    vf.setEstComplet(true);
                }
                else{
                    vf.setEstComplet(false);
                }

                ManagerVoyageFutur.add(vf, ctx);
            }
        });


        btn_ajout.setOnClickListener(listener) ;
        btn_trouver.setOnClickListener(listener) ;
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
