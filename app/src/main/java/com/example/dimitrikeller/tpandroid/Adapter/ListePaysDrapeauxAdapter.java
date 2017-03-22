package com.example.dimitrikeller.tpandroid.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.Service.BDHelper;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Marianne on 2017-03-15.
 */





public class ListePaysDrapeauxAdapter extends ArrayAdapter {

    int idLayout;
    Context ctx;
    FrameLayout fl;
    ImageButton imgBtn;
    TextView tv;
    int imgIdressource;

    public ListePaysDrapeauxAdapter(Context context, int resource, List<Pays> objects) {
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


        String name = lePays.getRessImgDrapeau();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");





        imgBtn = (ImageButton) convertView.findViewById(R.id.avp_img_btn);
        imgBtn.setImageResource(imgIdressource);
        tv= (TextView) convertView.findViewById(R.id.avp_tv);
        tv.setText(lePays.getNom());


        return convertView;
    }

}
