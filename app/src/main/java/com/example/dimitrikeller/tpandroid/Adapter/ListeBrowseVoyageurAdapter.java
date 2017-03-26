package com.example.dimitrikeller.tpandroid.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

/**
 * Created by Marianne on 2017-03-26.
 */

public class ListeBrowseVoyageurAdapter extends ArrayAdapter<Voyageur> {

    int idLayout;
    Context ctx;
    TextView tv_nom, tv_categorie;
    ImageView img;
    int imgIdressource;

    public ListeBrowseVoyageurAdapter( Context context,  int resource,  List<Voyageur> objects) {
        super(context, 0, objects);

        idLayout=resource;
        ctx = context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        Voyageur voy = (Voyageur) getItem(position);

        if(convertView == null){
            LayoutInflater inflator = LayoutInflater.from(ctx);
            convertView = inflator.inflate(idLayout,null);
        }

        tv_nom = (TextView) convertView.findViewById(R.id.vp_listeVoyageur_nom);
        tv_categorie = (TextView) convertView.findViewById(R.id.vp_listeVoyageur_categorie);
        img = (ImageView) convertView.findViewById(R.id.vp_listeVoyageur_img);

        String name = voy.getRessImgProfil();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");

        img.setImageResource(imgIdressource);
        tv_nom.setText(voy.getPenom() + " " + voy.getNom());
        tv_categorie.setText(voy.getCategorieVoyageur());

        return convertView;
    }
}
