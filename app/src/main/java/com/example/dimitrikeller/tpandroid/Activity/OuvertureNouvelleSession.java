package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dimitrikeller.tpandroid.Entite.Utilisateur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerUtilisateur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;

public class OuvertureNouvelleSession extends AppCompatActivity {

    EditText ed_identifiant, ed_motDePasse;
    Button btnSuivant;
    String stringIdentifiant, stringMotDePasse;
    Context ctx;
    SharedPreferences pref;
    SharedPreferences.Editor editeur;
    private final String id = "xczvxcvdwerfrsdfs";
    int idVoyageur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouverture_nouvelle_session);

        ed_identifiant = (EditText) findViewById(R.id.ons_identifiant);
        ed_motDePasse = (EditText) findViewById(R.id.ons_mot_passe);
        btnSuivant = (Button) findViewById(R.id.ons_btn_suivant);

        ctx = this;
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stringIdentifiant=  ed_identifiant.getText().toString();
                stringMotDePasse = ed_motDePasse.getText().toString();

                if (stringIdentifiant.equals("") || stringMotDePasse.equals("")){
                    Toast.makeText(ctx, "Veuillez entrer un identifiant et un mot de passe", Toast.LENGTH_SHORT).show();
                }
                else{


                    ArrayList<Utilisateur> lesUsers =  ManagerUtilisateur.getAll(ctx);

                    for (Utilisateur u: lesUsers){
                        if (u.getIdentifiant().equals(stringIdentifiant) && u.getMotPasse().equals(stringMotDePasse))
                            idVoyageur = u.getIdVoyageur();
                    }


                    editeur = pref.edit();
                    int valeurASauvegarder =  idVoyageur;
                    editeur.putInt(id,valeurASauvegarder);
                    editeur.commit();


                    Intent intent = new Intent(OuvertureNouvelleSession.this, MenuPrincipal.class);
                    startActivity(intent);

                }
            }
        });







    }
}
