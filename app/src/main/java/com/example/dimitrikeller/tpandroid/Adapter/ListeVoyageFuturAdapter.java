package com.example.dimitrikeller.tpandroid.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Marianne on 2017-03-18.
 */

public class ListeVoyageFuturAdapter extends ArrayAdapter<VoyageFutur> {
    int idLayout;
    Context ctx;
    ImageButton vp_lvf_img;
    TextView vp_lvf_tv_nom, vp_lvf_tv_dateDepart, vp_lvf_tv_dateRetour, vp_lvf_tv_complet;
    Button vp_lvf_btn_invitation, vp_lvf_btn_compagnon;
    Date dateDep, dateRet;
    String dateDepart, dateRetour;

    public ListeVoyageFuturAdapter(Context context, int resource, List<VoyageFutur> objects) {
        super(context, 0, objects);
        idLayout=resource;
        ctx=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        VoyageFutur vf = getItem(position);

        if(convertView == null){
            LayoutInflater inflator = LayoutInflater.from(ctx);
            convertView = inflator.inflate(idLayout,null);
        }

        vp_lvf_img = (ImageButton) convertView.findViewById(R.id.vp_listeVoyageFutur_img);
        vp_lvf_img.setImageResource(Integer.parseInt(ManagerPays.getById(ctx, vf.getIdPays()).getRessImgPays()));

        vp_lvf_tv_nom = (TextView) convertView.findViewById(R.id.vp_listeVoyageFutur_tv_nomPays);
        vp_lvf_tv_nom.setText(Integer.parseInt(ManagerPays.getById(ctx, vf.getIdPays()).getNom()));

        dateDepart = dateRetour = null;
        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateString = new SimpleDateFormat("dd MMMM yyyy");
        try {
            dateDep = dates.parse(vf.getDateDepart());
            dateRet= dates.parse(vf.getDateRetour());
            dateDepart = dateString.format(dateDep);
            dateRetour = dateString.format(dateRet);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        vp_lvf_tv_dateDepart= (TextView) convertView.findViewById(R.id.vp_listeVoyageFutur_tv_dateDepart);
        vp_lvf_tv_dateDepart.setText(dateDepart);

        vp_lvf_tv_dateRetour = (TextView) convertView.findViewById(R.id.vp_listeVoyageFutur_tv_dateRetour);
        vp_lvf_tv_dateRetour.setText(dateRetour);

        vp_lvf_tv_complet = (TextView) convertView.findViewById(R.id.vp_listeVoyageFutur_tv_complet);
        if (vf.getEstComplet()){
            vp_lvf_tv_complet.setText("complet");
        }
       else{
            vp_lvf_tv_complet.setText("Compagnons recherchés");
        }


        vp_lvf_btn_invitation = (Button) convertView.findViewById(R.id.vp_listeVoyageFutur_btn_invitation);

        vp_lvf_btn_compagnon = (Button) convertView.findViewById(R.id.vp_listeVoyageFutur_btn_compagnon);

        return convertView;
    }
}
