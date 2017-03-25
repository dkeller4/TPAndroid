package com.example.dimitrikeller.tpandroid.VuePerso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;
import com.example.dimitrikeller.tpandroid.R;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-24.
 */

public class VueSelecteurVoyage extends View implements Runnable{

    Handler handler;
    Context ctx;


    int wS, hS, wC;
    int xAvion, yAvion, xNuage1, xNuage2, xNuage3, yNuage1,  yNuage2,  yNuage3, stepNuage1, stepNuage2, stepNuage3;
    Rect rAvion, rNuage1, rNuage2, rNuage3, rSoleil;
    Bitmap img_soleil, img_avion, img_nuage;
    String msg1, msg2, msg3;
    TextView tv;
    Boolean isAnim;


    public VueSelecteurVoyage(Context context, Handler handler) {
        super(context);
        this.handler=handler;
        ctx = context;




        setBackgroundColor(Color.parseColor("#7CB3FF"));

        wC = 100;
        wS = getResources().getDisplayMetrics().widthPixels;
        hS = getResources().getDisplayMetrics().heightPixels;
        xAvion = 0;
        yAvion = hS-200;
        rAvion = new Rect(xAvion,yAvion,xAvion+wC,yAvion+wC);

        xNuage1 = wS/2;
        xNuage2 = wS/4;
        xNuage3 = wS/5;
        yNuage1 = 300;
        yNuage2 = 700;
        yNuage3 = 500;
        rNuage1 = new Rect(xNuage1,yNuage1,xNuage1+wC,yNuage1+wC);
        rNuage2 = new Rect(xNuage2,yNuage2,xNuage2+wC,yNuage2+wC);
        rNuage3 = new Rect(xNuage3,yNuage3,xNuage3+wC,yNuage3+wC);
        stepNuage1 =1;
        stepNuage2 =-2;
        stepNuage3 =3;

        rSoleil = new Rect(100,100, 300,300);


        msg1 = "Compas de Voyage  ";
        msg2 ="Le sélecteur de destination pour ceux qui n'arrivent pas à décider où patir !!";
        msg3 ="Toucher l'écran pour être transporter vers votre prochaine destination";


        img_soleil = BitmapFactory.decodeResource(getResources(), R.drawable.anim_soleil);
        img_nuage = BitmapFactory.decodeResource(getResources(), R.drawable.anim_nuage);
        img_avion = BitmapFactory.decodeResource(getResources(), R.drawable.anim_avion);

        tv = new TextView(context);
        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.layout(0,100, wS, hS);
        tv.setText(msg1 + "\n \n \n" + msg2+ "\n \n \n" + msg3);
        tv.setTextSize(24);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv.setTextAlignment(TEXT_ALIGNMENT_CENTER);

        }


        isAnim = false;


    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (!isAnim ) {
            tv.draw(canvas);
        }
        else{
            canvas.drawBitmap(img_soleil, null, rSoleil, null);
            canvas.drawBitmap(img_nuage, null, rNuage1, null);
            canvas.drawBitmap(img_nuage, null, rNuage2, null);
            canvas.drawBitmap(img_nuage, null, rNuage3, null);
            canvas.drawBitmap(img_avion, null, rAvion, null);
        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(wS, hS);
    }

    @Override
    public void run() {

        isAnim = true;

        xAvion +=2;
        yAvion -=3;

        xNuage1 +=stepNuage1;
        xNuage2 +=stepNuage2;
        xNuage3 +=stepNuage3;

        if(xNuage1 <= 0 || xNuage1>=wS -150) stepNuage1*=-1;
        if(xNuage2 <= 0 || xNuage2>=wS -150) stepNuage2*=-1;
        if(xNuage3 <= 0 || xNuage3>=wS -150) stepNuage3*=-1;

        rAvion = new Rect(xAvion,yAvion,xAvion+wC,yAvion+wC);
        rNuage1 = new Rect(xNuage1,yNuage1,xNuage1+wC,yNuage1+wC);
        rNuage2 = new Rect(xNuage2,yNuage2,xNuage2+wC,yNuage2+wC);
        rNuage3 = new Rect(xNuage3,yNuage3,xNuage3+wC,yNuage3+wC);

        invalidate();


        handler.post(this);
    }

}


