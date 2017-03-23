package com.example.dimitrikeller.tpandroid.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.ImageProfil;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

/**
 * Created by Marianne on 2017-03-22.
 */

public class ListeImageProfilSelectionAdapter extends ArrayAdapter {
    int idLayout;
    Context ctx;
    ImageView imgBtn;
    int imgIdressource;

    public ListeImageProfilSelectionAdapter( Context context, int resource, List objects) {
        super(context, 0, objects);

        idLayout=resource;
        ctx = context;

    }



    public View getView(int position, View convertView, ViewGroup parent){
        ImageProfil img  = (ImageProfil) getItem(position);

        if(convertView == null){
            LayoutInflater inflator = LayoutInflater.from(ctx);
            convertView = inflator.inflate(idLayout,null);
        }


        String name = img.getRessImage();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");

        imgBtn = (ImageView) convertView.findViewById(R.id.vp_imageProfilSelect_img);
        imgBtn.setImageResource(imgIdressource);



        return convertView;
    }



}
