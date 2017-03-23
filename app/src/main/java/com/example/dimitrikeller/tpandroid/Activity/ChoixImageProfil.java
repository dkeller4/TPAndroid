package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.dimitrikeller.tpandroid.Adapter.ListeImageProfilSelectionAdapter;
import com.example.dimitrikeller.tpandroid.Entite.ImageProfil;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerImageProfil;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

public class ChoixImageProfil extends AppCompatActivity {
    private final String id = "xczvxcvdwerfrsdfs";
    SharedPreferences pref;
    int idVoyageur;
    Context ctx;

    GridView gv;
    List<ImageProfil> lesImg;
    ListeImageProfilSelectionAdapter imgAdapt;

    String imgRess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_image_profil);

        ctx=this;

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        idVoyageur = pref.getInt(id,-1);

        gv = (GridView) findViewById(R.id.cip_image);


        lesImg = ManagerImageProfil.getAll(getBaseContext());
        imgAdapt = new ListeImageProfilSelectionAdapter(this, R.layout.vue_perso_image_profil_selection, lesImg);
        gv.setAdapter(imgAdapt);


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                imgRess =  lesImg.get(position).getRessImage();
                Voyageur voy = new Voyageur();
                voy=  ManagerVoyageur.getById(ctx, idVoyageur);
                voy.setRessImgProfil(imgRess);
                ManagerVoyageur.update(voy, ctx);

                Intent intent = new Intent(ChoixImageProfil.this, ProfilUtilisateur.class );
                startActivity(intent);

            }
        });


    }
}
