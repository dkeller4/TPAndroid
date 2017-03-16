package com.example.dimitrikeller.tpandroid.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

public class AjoutVoyageFutur extends AppCompatActivity {

    private AutoCompleteTextView actv;
    String[] listeNomPays;
    List<Pays> lesPays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_voyage_futur);

        actv = (AutoCompleteTextView) findViewById(R.id.avf_autoCompleteTextView1);
        lesPays = ManagerPays.getAll();
        listeNomPays = new String[lesPays.size()];

        int i = 0;
        for (Pays p: lesPays){
            listeNomPays[i]=p.getNom();
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,listeNomPays);
        actv.setAdapter(adapter);

    }

}
