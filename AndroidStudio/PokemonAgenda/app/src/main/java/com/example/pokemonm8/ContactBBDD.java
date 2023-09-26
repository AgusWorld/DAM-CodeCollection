package com.example.pokemonm8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactBBDD extends SQLiteOpenHelper {

    // En este caso la BBDD solo tiene una tabla, asi que solo creamos un sql de creacion�+
    // Si hubiese mas tablas, tendrianmos que crear todas las tablas y relaciones aqu�,

    String sqlCreacion ="CREATE TABLE agenda (id integer primary key autoincrement, " +
            "Nom text  not null, Num_Telefon text not null, PFP text, Gender text not null,Team text not null);";

    //String sqlCreacion2 ="CREATE TABLE names (idUsuari integer primary key autoincrement, " +
            //"Nomusuari text," +
            //"FOREIGN KEY (Nomusuari) REFERENCES agenda(Nom));";

    public ContactBBDD(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("drop table if exists agenda");
        //db.execSQL("drop table if exists names");
        db.execSQL(sqlCreacion);
        //db.execSQL(sqlCreacion2);

    }
    @Override
    public void onOpen(SQLiteDatabase db){
//        db.execSQL("drop table if exists agenda");
//        db.execSQL(sqlCreacion);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Nom�s s'executa quan la versi� de la BBDD amb la que cridem es superior a l'actual
        // S'hauria de fer una micraci� de dades. Nosaltres simplment esborrament les dades
        // antigues i crearem la nova estructura.

        db.execSQL(sqlCreacion);
        // Tamb� �s podria fer:
        // onCreate(db);
    }

}
