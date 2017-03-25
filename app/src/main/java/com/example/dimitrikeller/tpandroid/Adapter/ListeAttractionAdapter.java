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

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

/**
 * Created by Marianne on 2017-03-24.
 */

public class ListeAttractionAdapter extends ArrayAdapter{

    int idLayout;
    Context ctx;
    int imgIdressource;
    ImageView imgAtt;
    TextView tv_nom, tv_ville;

    public ListeAttractionAdapter( Context context,  int resource,  List objects) {
        super(context, 0, objects);
        idLayout=resource;
        ctx = context;

    }


    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        Attraction attraction = (Attraction) getItem(position);

        if(convertView == null){
            LayoutInflater inflator = LayoutInflater.from(ctx);
            convertView = inflator.inflate(idLayout,null);
        }

        imgAtt = (ImageView) convertView.findViewById(R.id.vp_listeAttraction_img);
        tv_nom = (TextView) convertView.findViewById(R.id.vp_listeAttraction_tv_nom);
        tv_ville = (TextView) convertView.findViewById(R.id.vp_listeAttraction_tv_ville);


        String name = attraction.getRessImgAttraction();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");

        imgAtt.setImageResource(imgIdressource);
        tv_nom.setText(attraction.getNom());
        tv_ville.setText(attraction.getVille());


    return convertView;
    }
}
