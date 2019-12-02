package com.example.rdef.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private String creation="create table developpeur("
            + "id_developpeur INT PRIMARY KEY NOT NULL AUTO_INCREMENT"
            + "nom TEXT  NOT NULL"
            + "prenom TEXT  NOT NULL"
            + "domaine_developpement TEXT  NOT NULL"
            + "niveau_etude TEXT  NOT NULL"
            + "technologies TEXT  NOT NULL"
            + "environnement TEXT  NOT NULL"
            + "note TEXT"
            + "mail TEXT  NOT NULL"
            + "telephone TEXT  NOT NULL"
            + "grade TEXT  NOT NULL"
            + "date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP )";


    /**
     * constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Si changement de base de données
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creation);

    }

    /**
     * si changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
