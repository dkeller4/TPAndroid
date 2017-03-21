package com.example.dimitrikeller.tpandroid.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Marianne on 2017-03-20.
 */

public class ConnexionBD {

        private static SQLiteDatabase bd;
        private static String database = "voyage";
        private static int version = 1;

        public static SQLiteDatabase getBD(Context ctx){
            BDHelper pH = new BDHelper(ctx,database,null,version);
            return  bd = pH.getWritableDatabase();
        }

        public static void close(){
            bd.close();
        }


    }
