package com.example.dimitrikeller.tpandroid.VuePerso;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.LanguePays;
import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangue;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Marianne on 2017-03-17.
 */

public class Vp_profil_pays_bref extends LinearLayout{

    Context ctx;
    int idPays;
    Pays lePays;
    TextView vp_ppb_tv_nom, vp_ppb_tv_continent, vp_ppb_tv_capitale, vp_ppb_tv_population, vp_ppb_tv_devise, vp_ppb_tv_langues;
    ImageView vp_ppb_img;
    LinearLayout vp_ppb_ll_horizontal1, vp_ppb_ll_horizontal2, vp_ppb_ll_continent, vp_ppb_ll_capitale, vp_ppb_ll_population, vp_ppb_ll_devise, vp_ppb_ll_langues;
    
    
    public Vp_profil_pays_bref(Context context, AttributeSet attrs) {
        super(context, attrs);

        ctx=context;
        setOrientation(VERTICAL);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setBackgroundColor(Color.rgb(171,207,255));

        idPays =10;
        lePays = new Pays();
        lePays= ManagerPays.getById(context, idPays);

        vp_ppb_tv_nom = new TextView(ctx);
        vp_ppb_tv_nom.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_tv_nom.setText(lePays.getNom());
        vp_ppb_tv_nom.setAllCaps(true);
        vp_ppb_tv_nom.setTextSize(40);
        vp_ppb_tv_nom.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        vp_ppb_tv_nom.setTextColor(Color.rgb(217,135,0));

        vp_ppb_img = new ImageView(ctx);
        vp_ppb_img.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_img.setImageResource(Integer.parseInt(lePays.getRessImgPays()));
        vp_ppb_img.setPadding(0,0,0,0);
        vp_ppb_img.setAdjustViewBounds(true);

        vp_ppb_ll_horizontal1 = new LinearLayout(ctx);
        vp_ppb_ll_horizontal1.setOrientation(HORIZONTAL);
        vp_ppb_ll_horizontal1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        vp_ppb_ll_continent = new LinearLayout(ctx);
        vp_ppb_ll_continent.setOrientation(VERTICAL);
        vp_ppb_ll_continent.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        vp_ppb_tv_continent = new TextView(ctx);
        vp_ppb_tv_continent.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_tv_continent.setText("Continent: " + lePays.getContinent());
        vp_ppb_tv_continent.setTextColor(Color.rgb(217,135,0));
        vp_ppb_tv_continent.setTextSize(16);

        vp_ppb_ll_continent.addView(vp_ppb_tv_continent);

        vp_ppb_ll_capitale = new LinearLayout(ctx);
        vp_ppb_ll_capitale.setOrientation(VERTICAL);
        vp_ppb_ll_capitale.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_ll_capitale.setPadding(50,0,0,0);


        vp_ppb_tv_capitale = new TextView(ctx);
        vp_ppb_tv_capitale.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_tv_capitale.setText("Capitale: " + lePays.getCapitale());
        vp_ppb_tv_capitale.setTextColor(Color.rgb(217,135,0));
        vp_ppb_tv_capitale.setTextSize(16);

        vp_ppb_ll_capitale.addView(vp_ppb_tv_capitale);


        vp_ppb_ll_horizontal1.addView(vp_ppb_ll_continent);
        vp_ppb_ll_horizontal1.addView(vp_ppb_ll_capitale);

        vp_ppb_ll_horizontal2 = new LinearLayout(ctx);
        vp_ppb_ll_horizontal2.setOrientation(HORIZONTAL);
        vp_ppb_ll_horizontal2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        vp_ppb_ll_population = new LinearLayout(ctx);
        vp_ppb_ll_population.setOrientation(VERTICAL);
        vp_ppb_ll_population.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        vp_ppb_tv_population = new TextView(ctx);
        vp_ppb_tv_population.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_tv_population.setText("Population: " + lePays.getPopulation());
        vp_ppb_tv_population.setTextColor(Color.rgb(217,135,0));
        vp_ppb_tv_population.setTextSize(16);

        vp_ppb_ll_population.addView(vp_ppb_tv_population);

        vp_ppb_ll_devise = new LinearLayout(ctx);
        vp_ppb_ll_devise.setOrientation(VERTICAL);
        vp_ppb_ll_devise.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_ll_devise.setPadding(50,0,0,0);

        vp_ppb_tv_devise = new TextView(ctx);
        vp_ppb_tv_devise.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_tv_devise.setText("Devise: " + lePays.getDevise());
        vp_ppb_tv_devise.setTextColor(Color.rgb(217,135,0));
        vp_ppb_tv_devise.setTextSize(16);

        vp_ppb_ll_devise.addView(vp_ppb_tv_devise);


        vp_ppb_ll_horizontal2.addView(vp_ppb_ll_population);
        vp_ppb_ll_horizontal2.addView(vp_ppb_ll_devise);

        ArrayList<LanguePays> langue = lePays.getListeLanguePays();
        int nbLangues = langue.size();
        Log.d("debug", "" + nbLangues);
        String lesLangues = null;
        if (nbLangues ==1) lesLangues = ManagerLangue.getById(context, langue.get(0).getIdLangue()).getLangue();
        if (nbLangues ==2) lesLangues = (ManagerLangue.getById(context, langue.get(0).getIdLangue()).getLangue() + ", "
                + ManagerLangue.getById(context, langue.get(1).getIdLangue()).getLangue());
        if (nbLangues ==3) lesLangues = ManagerLangue.getById(context, langue.get(0).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(context, langue.get(1).getIdLangue()).getLangue()+ ", "
                + ManagerLangue.getById(context, langue.get(2).getIdLangue()).getLangue();

        vp_ppb_tv_langues = new TextView(ctx);
        vp_ppb_tv_langues.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        vp_ppb_tv_langues.setText("Langues: " + lesLangues);
        vp_ppb_tv_langues.setTextColor(Color.rgb(217,135,0));
        vp_ppb_tv_langues.setTextSize(16);

        addView(vp_ppb_tv_nom);
        addView(vp_ppb_img);
        addView(vp_ppb_ll_horizontal1);
        addView(vp_ppb_ll_horizontal2);
        addView(vp_ppb_tv_langues);

    }
}
