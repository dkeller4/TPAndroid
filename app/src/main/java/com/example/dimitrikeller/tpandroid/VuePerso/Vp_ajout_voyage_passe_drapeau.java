package com.example.dimitrikeller.tpandroid.VuePerso;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.R;

import java.util.List;

/**
 * Created by Marianne on 2017-03-15.
 */





public class Vp_ajout_voyage_passe_drapeau extends ArrayAdapter {

    int idLayout;
    Context ctx;
    FrameLayout fl;
    ImageButton imgBtn;
    TextView tv;


    public Vp_ajout_voyage_passe_drapeau(Context context, int resource, List<Pays> objects) {
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

        imgBtn = (ImageButton) convertView.findViewById(R.id.avp_img_btn);
        imgBtn.setImageResource(lePays.getRessImgDrapeau());
        tv= (TextView) convertView.findViewById(R.id.avp_tv);
        tv.setText(lePays.getNom());


        return convertView;
    }

}
