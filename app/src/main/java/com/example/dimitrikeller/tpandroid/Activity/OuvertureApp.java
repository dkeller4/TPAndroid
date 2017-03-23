package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dimitrikeller.tpandroid.R;

public class OuvertureApp extends AppCompatActivity {

    Button btnEnregistre, btnNouvelleSession, btnDerniereSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouverture_app);


        btnEnregistre = (Button) findViewById(R.id.ouverture_enregistrer);
        btnNouvelleSession = (Button) findViewById(R.id.ouverture_ouv_nouvelle_session);
        btnDerniereSession = (Button) findViewById(R.id.ouverture_ouv_derniere_session);


        btnEnregistre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OuvertureApp.this, EnregistrementNouvelUtilisateur.class);
                startActivity(intent);
            }
        });

        btnNouvelleSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OuvertureApp.this, OuvertureNouvelleSession.class);
                startActivity(intent);
            }
        });

        btnDerniereSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OuvertureApp.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });

    }
}
