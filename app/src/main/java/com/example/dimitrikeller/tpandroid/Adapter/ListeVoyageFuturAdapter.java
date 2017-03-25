package com.example.dimitrikeller.tpandroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Activity.AjoutCompgnonListeVoyageur;
import com.example.dimitrikeller.tpandroid.Activity.MesVoyagesFuturs;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.VoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageFutur;
import com.example.dimitrikeller.tpandroid.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Marianne on 2017-03-18.
 */

public class ListeVoyageFuturAdapter extends ArrayAdapter<VoyageFutur> {
    int idLayout;
    Context ctx;
    ImageView vp_lvf_img;
    TextView vp_lvf_tv_nom, vp_lvf_tv_dateDepart, vp_lvf_tv_dateRetour, vp_lvf_tv_complet;
    Button vp_lvf_btn_invitation, vp_lvf_btn_compagnon;
    Date dateDep, dateRet;
    String dateDepart, dateRetour;
    int imgIdressource;
    Pays lePays;
    private final String id = "xczvxcvdwerfrsdfs";
    SharedPreferences pref;
    int idVoyageur;

    public ListeVoyageFuturAdapter(Context context, int resource, List<VoyageFutur> objects) {
        super(context, 0, objects);
        idLayout=resource;
        ctx=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        VoyageFutur vf = (VoyageFutur) getItem(position);

        if(convertView == null){
            LayoutInflater inflator = LayoutInflater.from(ctx);
            convertView = inflator.inflate(idLayout,null);
        }

        lePays = new Pays();
        int idPays = vf.getIdPays();
        lePays = ManagerPays.getById(ctx, idPays);
        Log.d("Debug", "" + idPays);
        String name = lePays.getRessImgPays();
        imgIdressource = ctx.getResources().getIdentifier(name, "drawable", "com.example.dimitrikeller.tpandroid");


        vp_lvf_img = (ImageView) convertView.findViewById(R.id.vp_listeVoyageFutur_img);
        vp_lvf_img.setImageResource(imgIdressource);

        vp_lvf_tv_nom = (TextView) convertView.findViewById(R.id.vp_listeVoyageFutur_tv_nomPays);
        vp_lvf_tv_nom.setText(lePays.getNom());

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



        return convertView;
    }
}
