package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfilVoyageFutur extends AppCompatActivity {

    Intent intentRetour;
    int idVf;
    VoyageFutur leVf;
    int idPays;
    Pays lePays;
    Voyageur voy;
    Context ctx;

    TextView tv_nomPays, tv_nom, tv_dateDepart, tv_dateRetour, tv_complet;
    ImageButton imgPays;
    Button btn_ajouter, btn_trouver, btn_invitation;
    String name;
    int imgIdREssource;
    Date dateDep, dateRet;
    String dateDepart, dateRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_voyage_futur);

        ctx =this;

        intentRetour = getIntent();
        idVf = intentRetour.getIntExtra("idVf", -1);
        leVf = ManagerVoyageFutur.getByIdVoyageFutur(ctx, idVf);
        idPays = leVf.getIdPays();
        lePays = ManagerPays.getById(ctx, idPays);
        voy = ManagerVoyageur.getById(ctx, leVf.getIdVoyageurPrincipal());

        tv_nomPays = (TextView) findViewById(R.id.pvf_nomPays);
        tv_nom = (TextView) findViewById(R.id.pvf_nom);
        tv_dateDepart = (TextView) findViewById(R.id.pvf_dateDepart);
        tv_dateRetour = (TextView) findViewById(R.id.pvf_dateRetour);
        tv_complet = (TextView) findViewById(R.id.pvf_complet);
        imgPays = (ImageButton) findViewById(R.id.pvf_img);
        btn_ajouter= (Button) findViewById(R.id.pvf_ajouter);
        btn_trouver = (Button) findViewById(R.id.pvf_trouver);
        btn_invitation = (Button) findViewById(R.id.pvf_invitation);

        name = lePays.getRessImgPays();
        imgIdREssource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");

        imgPays.setImageResource(imgIdREssource);
        tv_nomPays.setText(lePays.getNom());
        tv_nom.setText(voy.getPenom() + " " + voy.getNom());


        dateDepart = dateRetour = null;
        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateString = new SimpleDateFormat("dd MMMM yyyy");
        try {
            dateDep = dates.parse(leVf.getDateDepart());
            dateRet= dates.parse(leVf.getDateRetour());
            dateDepart = dateString.format(dateDep);
            dateRetour = dateString.format(dateRet);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        tv_dateDepart.setText(dateDepart);
        tv_dateRetour.setText(dateRetour);

        if (leVf.getEstComplet()){
            tv_complet.setText("Est Complet");
        }
        else {
            tv_complet.setText("Compagnons recherchés");
        }


        imgPays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new  Intent(ProfilVoyageFutur.this, ProfilPays.class);
                intent.putExtra("idPays", idPays);
                startActivity(intent);

            }
        });

        btn_trouver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!leVf.getEstComplet()) {
                    Intent intent = new Intent(ProfilVoyageFutur.this, AjoutCompagnonParInvitation.class);
                    intent.putExtra("idVf", idVf);
                    startActivity(intent);
                }
            }
        });

        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!leVf.getEstComplet()) {
                    Intent intent = new Intent(ProfilVoyageFutur.this, AjoutCompgnonListeVoyageur.class);
                    intent.putExtra("idVf", idVf);
                    startActivity(intent);
                }
            }
        });

        btn_invitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilVoyageFutur.this, ConsultationInvitationVoyage.class);
                intent.putExtra("idVf", idVf);
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
