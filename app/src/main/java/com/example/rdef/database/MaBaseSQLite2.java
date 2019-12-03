package com.example.rdef.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MaBaseSQLite2 extends SQLiteOpenHelper {

    private static final String TABLE_dev = "developpeur";
    private static final String TABLE_projet = "projet";
    private static final String TABLE_visiteur = "visiteur";
    private static final String TABLE_notification = "notification_projet";
    private static final String TABLE_notification_profil = "notification_profil";

    private static final String creation="create table developpeur("
            + "id_developpeur INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nom TEXT  NOT NULL,"
            + "prenom TEXT  NOT NULL,"
            + "domaine_developpement TEXT  NOT NULL,"
            + "niveau_etude TEXT  NOT NULL,"
            + "technologies TEXT  NOT NULL,"
            + "environnement TEXT  NOT NULL,"
            + "mail TEXT  NOT NULL unique,"
            + "password TEXT  NOT NULL,"
            + "telephone TEXT  ,"
            + "grade TEXT  NOT NULL," +
            "date_creation DATETIME DEFAULT CURRENT_TIMESTAMP)";
    private static final String creation2="create table projet("
            + "id_projet INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nom_projet TEXT  NOT NULL unique,"
            + "detail TEXT  NOT NULL,"
            + "recherche TEXT  NOT NULL,"
            + "id_auteur TEXT  NOT NULL,"
            + "date_creation DATETIME DEFAULT CURRENT_TIMESTAMP)";
    private static final String creation3="create table visiteur("
            + "id_visiteur INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "type TEXT  NOT NULL,"
            + "mail TEXT  NOT NULL unique,"
            + "password TEXT  NOT NULL,"
            + "nom TEXT,"
            + "prenom TEXT,"
            + "nom_entreprise TEXT,"
            + "responsable_rh TEXT,"
            + "telephone TEXT  NOT NULL,"
            + "date_creation DATETIME DEFAULT CURRENT_TIMESTAMP)";
    private static final String creation4="create table notification_projet("
            + "id_notification INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "id_projet TEXT  NOT NULL,"
            + "id_developpeur TEXT  NOT NULL,"
            + "date_creation DATETIME DEFAULT CURRENT_TIMESTAMP)";
    private static final String creation5="create table notification_profil("
            + "id_notification INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "id_visiteur TEXT  NOT NULL,"
            + "id_developpeur TEXT  NOT NULL,"
            + "date_creation DATETIME DEFAULT CURRENT_TIMESTAMP)";

    public MaBaseSQLite2(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(creation);
        db.execSQL(creation2);
        db.execSQL(creation3);
        db.execSQL(creation4);
        db.execSQL(creation5);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_dev + ";");
        db.execSQL("DROP TABLE " + TABLE_projet + ";");
        db.execSQL("DROP TABLE " + TABLE_visiteur + ";");
        db.execSQL("DROP TABLE " + TABLE_notification + ";");
        db.execSQL("DROP TABLE " + TABLE_notification_profil + ";");


        onCreate(db);
    }

}
