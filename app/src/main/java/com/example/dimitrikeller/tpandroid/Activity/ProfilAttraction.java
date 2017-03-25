package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Manager.ManagerAttraction;
import com.example.dimitrikeller.tpandroid.R;

public class ProfilAttraction extends AppCompatActivity {

    Intent intentRetour;
    Context ctx;
    int idAttraction;
    Attraction att;

    ImageView imgAtt;
    TextView tv_nom, tv_ville, tv_description, tv_duree, tv_gratuit, tv_tel, tv_web;
    int imgIdressource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_attraction);

        ctx=this;
        intentRetour = getIntent();
        idAttraction = intentRetour.getIntExtra("idAttraction", -1);
        att = ManagerAttraction.getById(ctx, idAttraction);

        imgAtt = (ImageView) findViewById(R.id.pa_img);
        tv_nom = (TextView) findViewById(R.id.pa_nom);
        tv_ville = (TextView) findViewById(R.id.pa_ville);
        tv_description = (TextView) findViewById(R.id.pa_description);
        tv_duree = (TextView) findViewById(R.id.pa_duree);
        tv_gratuit = (TextView) findViewById(R.id.pa_gratuit);
        tv_tel = (TextView) findViewById(R.id.pa_tel);
        tv_web = (TextView) findViewById(R.id.pa_web);

        String name = att.getRessImgAttraction();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");
        imgAtt.setImageResource(imgIdressource);

        tv_nom.setText(att.getNom());
        tv_ville.setText(att.getVille());
        tv_description.setText(att.getDescription());
        tv_duree.setText("Temps à prévoir: \n" + att.getDuree());
        tv_gratuit.setText("Activité gratuite: \n" + att.getGratuit());
        tv_tel.setText("Téléphone: \n"+ att.getTelephone());

        String linkText = "<a href='"+att.getWeb()+"'>Site Internet</a>";
        tv_web.setText(Html.fromHtml(linkText));
        tv_web.setMovementMethod(LinkMovementMethod.getInstance());



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
