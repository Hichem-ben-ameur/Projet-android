package com.example.rdef.Entity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rdef.database.MySQLiteOpenHelper;

import java.sql.Timestamp;
import java.util.Date;

public class Repository {
    //propiertés
    private String DbName="dev.sqlite";
    private Integer version =1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public Repository(Context contexte)
    {
        accesBD=new MySQLiteOpenHelper(contexte,DbName,null,version);
    }
    public void ajout(developpeur developpeur)
    {
        bd= accesBD.getWritableDatabase();
        String req = "insert into developpeur (nom,prenom,domaine_developpement,niveau_etude,technologies,environnement,note,mail,telephone,grade) values";
        req+="(\""+developpeur.getNom()+"\"," +
                "\""+developpeur.getPrenom()+"\"," +
                "\""+developpeur.getDomaine_developpement()+"\"," +
                "\""+developpeur.getNiveau_etude()+"\"," +
                "\""+developpeur.getTechnologies()+"\"," +
                "\""+developpeur.getEnvironnement()+"\"," +
                "\""+developpeur.getMail()+"\"," +
                "\""+developpeur.getTelephone()+"\"," +
                "\""+developpeur.getGrade()+"\","+")";
        bd.execSQL(req);
    }
    public developpeur getLast ()
    {
        bd = accesBD.getReadableDatabase();
        developpeur developpeur= null;
        String req="select * from developpeur";
        Cursor curseur = bd.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast())
        {
            Date date = new Date();
            String nom=curseur.getString(2);
            String prenom=curseur.getString(3);
            String domaine_developpement=curseur.getString(4);
            String niveau_etude=curseur.getString(5);
            String technologies=curseur.getString(6);
            String environnement=curseur.getString(7);
            String note=curseur.getString(8);
            String mail=curseur.getString(9);
            String telephone=curseur.getString(10);
            String grade=curseur.getString(11);
           // String date_creation=curseur.get(12);

        developpeur = new developpeur(nom, prenom,domaine_developpement,niveau_etude,technologies, environnement, mail,null, telephone, grade);
        curseur.close();

        }
        return developpeur;
    }

}
