package com.example.dimitrikeller.tpandroid.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        db.execSQL(ManagerVoyageur.VOYAGEUR_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(ManagerVoyageur.DROP_VOYAGEUR_TABLE);
        onCreate(db);
    }
}
