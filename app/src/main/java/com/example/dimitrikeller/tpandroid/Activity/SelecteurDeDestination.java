package com.example.dimitrikeller.tpandroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Langue;
import com.example.dimitrikeller.tpandroid.Entite.LanguePays;
import com.example.dimitrikeller.tpandroid.Entite.LangueVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.PreferencePays;
import com.example.dimitrikeller.tpandroid.Entite.PreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLanguePays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangueVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreferencePays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.VuePerso.VueSelecteurVoyage;

import java.util.ArrayList;

public class SelecteurDeDestination extends AppCompatActivity {

    Handler handler;
    Context ctx;
    VueSelecteurVoyage vsl;
    int idPaysToGo;


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        ctx = this;
        vsl = new VueSelecteurVoyage(ctx, handler);
        setContentView(vsl);
        idPaysToGo = selectionPays();



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {



        handler.post(vsl);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                intent = new Intent(SelecteurDeDestination.this, ProfilPays.class);
                intent.putExtra("idPays", idPaysToGo);
                startActivity(intent);
            }
        }, 2000);



        return super.onTouchEvent(event);
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

    public int selectionPays (){

        int idPays = (int)(Math.random() *232);


        return idPays;
    }




}
