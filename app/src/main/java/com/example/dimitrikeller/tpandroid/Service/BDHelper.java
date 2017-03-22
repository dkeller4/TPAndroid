package com.example.dimitrikeller.tpandroid.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dimitrikeller.tpandroid.Manager.ManagerAttraction;
import com.example.dimitrikeller.tpandroid.Manager.ManagerAttractionPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerCompagnonVoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerInvitationVoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangue;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLanguePays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerLangueVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreference;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreferencePays;
import com.example.dimitrikeller.tpandroid.Manager.ManagerPreferenceVoyageur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerUtilisateur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageFutur;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyagePasse;
import com.example.dimitrikeller.tpandroid.Manager.ManagerVoyageur;

/**
 * Created by Marianne on 2017-03-20.
 */

public class BDHelper extends SQLiteOpenHelper {


    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ManagerAttraction.ATTRACTION_TABLE_CREATE);
        db.execSQL(ManagerAttraction.queryINSERT);
        db.execSQL(ManagerAttractionPays.ATTRACTION_PAYS_TABLE_CREATE);
        db.execSQL(ManagerAttractionPays.queryINSERT);
        db.execSQL(ManagerCompagnonVoyageFutur.COMPAGNON_VOYAGE_FUTUR_TABLE_CREATE);
        db.execSQL(ManagerInvitationVoyageFutur.INVITATION_TABLE_CREATE);
        db.execSQL(ManagerLangue.LANGUE_TABLE_CREATE);
        db.execSQL(ManagerLangue.queryINSERT);
        db.execSQL(ManagerLanguePays.LANGUE_PAYS_TABLE_CREATE);
        db.execSQL(ManagerLanguePays.queryINSERT);
        db.execSQL(ManagerLangueVoyageur.LANGUE_VOYAGEUR_TABLE_CREATE);
        db.execSQL(ManagerPays.PAYS_TABLE_CREATE);
        db.execSQL(ManagerPays.queryINSERT);
        db.execSQL(ManagerPreference.PREFERENCE_TABLE_CREATE);
        db.execSQL(ManagerPreference.queryINSERT);
        db.execSQL(ManagerPreferencePays.PREFERENCE_PAYS_TABLE_CREATE);
        db.execSQL(ManagerPreferencePays.queryINSERT);
        db.execSQL(ManagerPreferenceVoyageur.PREFERENCE_VOYAGEUR_TABLE_CREATE);
        db.execSQL(ManagerVoyageFutur.VOYAGE_FUTUR_CREATE);
        db.execSQL(ManagerVoyagePasse.VOYAGE_PASSE_TABLE_CREATE);
        db.execSQL(ManagerVoyageur.VOYAGEUR_TABLE_CREATE);
        db.execSQL(ManagerUtilisateur.VOYAGEUR_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(ManagerAttraction.DROP_ATTRACTION_TABLE);
        db.execSQL(ManagerAttractionPays.DROP_ATTRACTION_PAYS_TABLE);
        db.execSQL(ManagerCompagnonVoyageFutur.DROP_ATTRACTION_PAYS_TABLE);
        db.execSQL(ManagerInvitationVoyageFutur.DROP_INVITATION_TABLE);
        db.execSQL(ManagerLangue.DROP_LANGUE_TABLE);
        db.execSQL(ManagerLanguePays.DROP_LANGUE_PAYS_TABLE);
        db.execSQL(ManagerLangueVoyageur.DROP_LANGUE_PAYS_TABLE);
        db.execSQL(ManagerPays.DROP_PAYS_TABLE);
        db.execSQL(ManagerPreference.DROP_PREFERENCE_TABLE);
        db.execSQL(ManagerPreferencePays.DROP_PREFERENCE_PAYS_TABLE);
        db.execSQL(ManagerPreferenceVoyageur.DROP_PREFERENCE_PAYS_TABLE);
        db.execSQL(ManagerVoyageFutur.DROP_VOYAGE_FUTUR_TABLE);
        db.execSQL(ManagerVoyagePasse.DROP_VOYAGE_PASSE_TABLE);
        db.execSQL(ManagerVoyageur.DROP_VOYAGEUR_TABLE);
        db.execSQL(ManagerUtilisateur.DROP_UTILISATEUR_TABLE);
        onCreate(db);
    }
}
