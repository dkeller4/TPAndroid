package com.example.dimitrikeller.tpandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

/**
 * Created by Marianne on 2017-03-23.
 */

public class ListeBrowsePaysAdapter extends ArrayAdapter<Pays> {

    int idLayout;
    Context ctx;
    TextView tv_nom, tv_capitale, tv_continent;
    ImageView img;
    int imgIdressource;

    public ListeBrowsePaysAdapter(Context context, int resource, List<Pays> objects) {
        super(context, 0, objects);
        idLayout=resource;
        ctx = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Pays lePays = (Pays) getItem(position);

        if(convertView == null){
            LayoutInflater inflator = LayoutInflater.from(ctx);
            convertView = inflator.inflate(idLayout,null);
        }

        String name = lePays.getRessImgPays();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");


        tv_nom = (TextView) convertView.findViewById(R.id.vppp_tv_nom);
        tv_capitale = (TextView) convertView.findViewById(R.id.vppp_tv_capitale);
        tv_continent = (TextView) convertView.findViewById(R.id.vppp_tv_continent);
        img= (ImageView) convertView.findViewById(R.id.vppp_img_pays);

        img.setImageResource(imgIdressource);

        tv_nom.setText(lePays.getNom());
        tv_capitale.setText(lePays.getCapitale());
        tv_continent.setText(lePays.getContinent());
        return convertView;
    }
}
