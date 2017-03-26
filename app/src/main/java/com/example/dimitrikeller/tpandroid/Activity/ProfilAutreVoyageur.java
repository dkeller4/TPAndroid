package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Adapter.ListeVoyageFuturAdapter;
import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.PreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangue;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangueVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreference;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProfilAutreVoyageur extends AppCompatActivity {

    Context ctx;
    ListView lv;
    ListeVoyageFuturAdapter vfAdapt;
    List<VoyageFutur> lesVf;
    int idVoyageur;
    TextView tv_nom, tv_categorie, tv_pays, tv_sexe, tv_age, tv_langues, tv_preferences;
    Intent intentRetour;
    Voyageur voy;
    ImageView img;
    String name;
    int imgIdRessource;
    Date dateAuj, dateNaiss;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_autre_voyageur);

        ctx = this;

        intentRetour = getIntent();
        idVoyageur = intentRetour.getIntExtra("idVoyageur", -1);
        voy = ManagerVoyageur.getById(ctx, idVoyageur);


        tv_nom = (TextView) findViewById(R.id.pav_nom);
        tv_categorie = (TextView) findViewById(R.id.pav_categorie);
        tv_pays = (TextView) findViewById(R.id.pav_pays);
        tv_sexe = (TextView) findViewById(R.id.pav_sexe);
        tv_age = (TextView) findViewById(R.id.pav_age);
        tv_langues = (TextView) findViewById(R.id.pav_langues);
        tv_preferences = (TextView) findViewById(R.id.pav_preferences);
        lv = (ListView) findViewById(R.id.pav_lv);
        img = (ImageView) findViewById(R.id.pav_img);

        name = voy.getRessImgProfil();
        imgIdRessource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");

        img.setImageResource(imgIdRessource);
        tv_nom.setText(voy.getPenom() + " " + voy.getNom());
        tv_categorie.setText(voy.getCategorieVoyageur());
        tv_pays.setText(voy.getPaysNaissance());
        if (voy.getSexe().equals("f"))
            tv_sexe.setText("Femme");
        if (voy.getSexe().equals("h"))
            tv_sexe.setText("Homme");

        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dateAuj = dates.parse(timeStamp);
            dateNaiss = dates.parse(voy.getDateNaissance());
            long difference = dateAuj.getTime() - dateNaiss.getTime();
            age = (int) (difference / (365.25 * 24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            e.printStackTrace();

        }

        tv_age.setText("" + age + " ans");

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

        tv_langues.setText(lesLangues);

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

        tv_preferences.setText(lesPreferences);

        lesVf = ManagerVoyageFutur.getAllByIdVoyageur(ctx, idVoyageur);
        vfAdapt = new ListeVoyageFuturAdapter(ctx, R.layout.vue_perso_liste_voyage_futur, lesVf);
        lv.setAdapter(vfAdapt);


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
