package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dimitrikeller.tpandroid.R;

public class MenuPrincipal extends AppCompatActivity {


    Button btn_profil, btn_pays, btn_voyageur, btn_compas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        btn_profil = (Button) findViewById(R.id.mp_profil);
        btn_pays = (Button) findViewById(R.id.mp_pays);
        btn_voyageur = (Button) findViewById(R.id.mp_voyageur);
        btn_compas = (Button) findViewById(R.id.mp_compas);


        btn_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, ProfilUtilisateur.class);
                startActivity(intent);
            }
        });

        btn_pays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, BrowseListePays.class);
                startActivity(intent);
            }
        });

        btn_voyageur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, BrowseListeVoyageur.class);
                startActivity(intent);
            }
        });

        btn_compas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, SelecteurDeDestination.class);
                startActivity(intent);
            }
        });

    }
}
