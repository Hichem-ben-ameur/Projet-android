package com.example.rdef.controleur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rdef.Entity.developpeur;
import com.example.rdef.Entity.Projet;
import com.example.rdef.database.MaBaseSQLite2;

import java.util.ArrayList;
import java.util.List;

public class ProjetBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "rdef.sqlite";

    private static final String TABLE_projet = "projet";
    private static final String COL_ID_projet = "id_projet";
    private static final int NUM_COL_ID_projet = 0;
    private static final String COL_NOM_projet = "nom_projet";
    private static final int NUM_COL_NOM_projet = 1;
    private static final String COL_DETAIL = "detail";
    private static final int NUM_COL_DETAIL = 2;
    private static final String COL_RECHERCHE = "recherche";
    private static final int NUM_COL_RECHERCHE = 3;
    private static final String COL_ID_AUTEUR = "id_auteur";
    private static final int NUM_ID_AUTEUR = 4;
    private static final String COL_DATE_CREATION_projet = "date_creation";
    private static final int NUM_DATE_CREATION_projet = 5;

    private SQLiteDatabase bdd;

    private MaBaseSQLite2 maBaseSQLite;

    public ProjetBDD(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new MaBaseSQLite2(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertProjet(Projet projet){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_NOM_projet, projet.getNom_projet());
        values.put(COL_DETAIL, projet.getDetail());
        values.put(COL_RECHERCHE, projet.getRecherche());
        values.put(COL_ID_AUTEUR, projet.getId_auteur());



        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_projet, null, values);
    }

   /* public int updateLivre(int id, developpeur developpeur){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_ISBN, livre.getIsbn());
        values.put(COL_TITRE, livre.getTitre());
        return bdd.update(TABLE_LIVRES, values, COL_ID + " = " +id, null);
    }

    public int removeLivreWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_LIVRES, COL_ID + " = " +id, null);
    }*/

  /*  public developpeur getLivreWithTitre(String PRENOM){
        Cursor c = bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION}, COL_ID + " = 1", null, null, null, null);
        return cursorToLivre(c);
    }*/
    public Projet getProjet(int id)
    {
        //Cursor c= bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION},  "mail=\""+mail+"\" and password=\""+password+"\"", null, null, null, null);
        Cursor cursor = bdd.rawQuery("select * from projet   where id_projet = ?  " , new String[]{Integer.toString(id)});

        return cursorToProjet(cursor);
    }

    public List<Projet> getAllProjets(){

        List<Projet> projets = new ArrayList<Projet>();
//resultat[0]="f";
        Integer i=0;
        //Cursor c = bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_DETAIL,COL_RECHERCHE,COL_ID_AUTEUR,COL_DATE_CREATION}, null, null, null, null, null);
        String req="select * from projet";
        Cursor curseur = bdd.rawQuery(req,null);
        curseur.moveToFirst();
        if(!curseur.isAfterLast())
        {
            do{
                Integer id=curseur.getInt(NUM_COL_ID_projet);
                String nom=curseur.getString(NUM_COL_NOM_projet);
                String detail=curseur.getString(NUM_COL_DETAIL);
                String recherche=curseur.getString(NUM_COL_RECHERCHE);
                String id_auteur=curseur.getString(NUM_ID_AUTEUR);
                String date_creation=curseur.getString(NUM_DATE_CREATION_projet);
                Projet projet = new Projet(nom, detail,recherche,id_auteur);
                projet.setDate_creation(date_creation);
                projet.setId_projet(id);
                // resultat[i]=developpeur.toString();

                projets.add(projet);
            }while (curseur.moveToNext());


        }


        curseur.close();
        return projets;
    }
    public String[] getAllIDS_projet(){
        String[] resultat=new String[50];
        Integer i=0;
        String req="select * from projet";
        Cursor curseur = bdd.rawQuery(req,null);
        curseur.moveToFirst();
        if(!curseur.isAfterLast())
        {
            do{
                Integer id=curseur.getInt(NUM_COL_ID_projet);
                resultat[i]=id.toString();
                //devs[i]=developpeur;
                i++;

            }while (curseur.moveToNext());


        }


        curseur.close();
        return resultat;
    }
    public Projet[] getAllProjets2(){

        Projet[] projets=new Projet[50];

//resultat[0]="f";
        Integer i=0;
       // Cursor c = bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION}, COL_ID + " = 1", null, null, null, null);
        String req="select * from projet";
        Cursor curseur = bdd.rawQuery(req,null);
        curseur.moveToFirst();
        if(!curseur.isAfterLast())
        {
            do{
                Integer id=curseur.getInt(NUM_COL_ID_projet);
                String nom=curseur.getString(NUM_COL_NOM_projet);
                String detail=curseur.getString(NUM_COL_DETAIL);
                String recherche=curseur.getString(NUM_COL_RECHERCHE);
                String id_auteur=curseur.getString(NUM_ID_AUTEUR);
                String date_creation=curseur.getString(NUM_DATE_CREATION_projet);
                Projet projet = new Projet(nom, detail,recherche,id_auteur);
                projet.setDate_creation(date_creation);
                projet.setId_projet(id);
                // resultat[i]=developpeur.toString();
                projets[i]=projet;
                i++;
               // tweets.add(developpeur);
            }while (curseur.moveToNext());


        }


        curseur.close();
        return projets;
    }

    private Projet cursorToProjet(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
        { return null;}

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Projet projet = new Projet();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        projet.setId_projet(c.getInt(NUM_COL_ID_projet));
        projet.setNom_projet(c.getString(NUM_COL_NOM_projet));
        projet.setDetail(c.getString(NUM_COL_DETAIL));
        projet.setRecherche(c.getString(NUM_COL_RECHERCHE));
        projet.setId_auteur(c.getString(NUM_ID_AUTEUR));
        projet.setDate_creation(c.getString(NUM_DATE_CREATION_projet));
        //On ferme le cursor
        c.close();


        return projet;
    }
}
