package com.example.rdef.controleur;

import android.app.Notification;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rdef.Entity.NotificationProjet;
import com.example.rdef.Entity.Projet;
import com.example.rdef.Entity.Visiteur;
import com.example.rdef.database.MaBaseSQLite2;
import com.example.rdef.Entity.developpeur;

import java.util.ArrayList;
import java.util.List;

 public  class DeveloppeurBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "rdef.sqlite";

    private static final String TABLE_dev = "developpeur";
    private static final String COL_ID = "id_developpeur";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "nom";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_PRENOM = "prenom";
    private static final int NUM_COL_PRENOM = 2;
    private static final String COL_DOMAINE_DEVELOPPEMENT = "domaine_developpement";
    private static final int NUM_COL_DOMAINE_DEVELOPPEMENT = 3;
    private static final String COL_NIVEAU_ETUDE = "niveau_etude";
    private static final int NUM_NIVEAU_ETUDE = 4;
    private static final String COL_THECHNOLOGIES = "technologies";
    private static final int NUM_COL_THECHNOLOGIES = 5;
    private static final String COL_ENVIRONNEMENT = "environnement";
    private static final int NUM_COL_ENVIRONNEMENT = 6;
    private static final String COL_MAIL = "mail";
    private static final int NUM_COL_MAIL = 7;
    private static final String COL_PASSWORD = "password";
    private static final int NUM_COL_PASSWORD = 8;
    private static final String COL_TELEPHONE = "telephone";
    private static final int NUM_TELEPHONE = 9;
    private static final String COL_GRADE = "grade";
    private static final int NUM_COL_GRADE = 10;
    private static final String COL_DATE_CREATION = "date_creation";
    private static final int NUM_DATE_CREATION = 11;
/********* projet attribues**********/
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
     /********* visiteur attribues**********/
     private static final String TABLE_visiteur = "visiteur";
     private static final String COL_ID_visiteur = "id_visiteur";
     private static final int NUM_COL_ID_visiteur = 0;
     private static final String COL_NOM_visiteur = "nom";
     private static final int NUM_COL_NOM_visiteur = 1;
     private static final String COL_PRENOM_visiteur = "prenom";
     private static final int NUM_COL_PRENOM_visiteur = 2;
     private static final String COL_NOM_entreprise_visiteur = "nom_entreprise";
     private static final int NUM_COL_NOM_entreprise_visiteur = 3;
     private static final String COL_responsable_rh_visiteur = "responsable_rh";
     private static final int NUM_responsable_rh_visiteur = 4;
     private static final String COL_DATE_CREATION_visiteur = "date_creation";
     private static final int NUM_DATE_CREATION_visiteur = 5;
     private static final String COL_telephone_visiteur = "telephone";
     private static final int NUM_COL_telephone_visiteur = 6;
     private static final String COL_MAIL_visiteur = "mail";
     private static final int NUM_COL_MAIL_visiteur = 7;
     private static final String COL_PASSWORD_visiteur = "password";
     private static final int NUM_COL_PASSWORD_visiteur = 8;
     private static final String COL_type_visiteur = "type";
     private static final int NUM_COL_type_visiteur = 9;
     /********* notification attribues**********/
     private static final String TABLE_notification = "notification_projet";
     private static final String COL_ID_notification = "id_notification";
     private static final int NUM_COL_ID_notification = 0;
     private static final String COL_ID_Projet_notification = "id_projet";
     private static final int NUM_ID_Projet_notification = 1;
     private static final String COL_ID_Developpeur_notification = "id_developpeur";
     private static final int NUM_ID_Developpeur_notification = 2;
     private static final String COL_date_creation_notification = "date_creation";
     private static final int NUM_date_creation_notification = 3;

    private SQLiteDatabase bdd;

    private MaBaseSQLite2 maBaseSQLite;

    public DeveloppeurBDD(Context context){
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

    public long insertDeveloppeur(developpeur developpeur){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_NOM, developpeur.getNom());
        values.put(COL_PRENOM, developpeur.getPrenom());
        values.put(COL_DOMAINE_DEVELOPPEMENT, developpeur.getDomaine_developpement());
        values.put(COL_NIVEAU_ETUDE, developpeur.getNiveau_etude());
        values.put(COL_THECHNOLOGIES, developpeur.getTechnologies());
        values.put(COL_ENVIRONNEMENT, developpeur.getEnvironnement());
        values.put(COL_MAIL, developpeur.getMail());
        values.put(COL_PASSWORD, developpeur.getPassword());
        values.put(COL_TELEPHONE, developpeur.getTelephone());
        values.put(COL_GRADE, developpeur.getGrade());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_dev, null, values);
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

    public developpeur getLivreWithTitre(String PRENOM){
        Cursor c = bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION}, COL_ID + " = 1", null, null, null, null);
        return cursorToLivre(c);
    }
public developpeur getDev(String mail, String password)
{
    //Cursor c= bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION},  "mail=\""+mail+"\" and password=\""+password+"\"", null, null, null, null);
    Cursor cursor = bdd.rawQuery("select * from developpeur   where mail = ?  AND  password = ? " , new String[]{mail, password });

    return cursorToLivre(cursor);
}

    public List<developpeur> getAllDeveloppeurs(){
        String[] resultat=new String[50];
        developpeur[] devs=new developpeur[50];
        List<developpeur> tweets = new ArrayList<developpeur>();
//resultat[0]="f";
        Integer i=0;
        Cursor c = bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION}, COL_ID + " = 1", null, null, null, null);
        String req="select * from developpeur";
        Cursor curseur = bdd.rawQuery(req,null);
        curseur.moveToFirst();
        if(!curseur.isAfterLast())
        {
            do{
                Integer id=curseur.getInt(NUM_COL_ID);
                String nom=curseur.getString(NUM_COL_NOM);
                String prenom=curseur.getString(NUM_COL_PRENOM);
                String domaine_developpement=curseur.getString(NUM_COL_DOMAINE_DEVELOPPEMENT);
                String niveau_etude=curseur.getString(NUM_NIVEAU_ETUDE);
                String technologies=curseur.getString(NUM_COL_THECHNOLOGIES);
                String environnement=curseur.getString(NUM_COL_ENVIRONNEMENT);
                String mail=curseur.getString(NUM_COL_MAIL);
                String telephone=curseur.getString(NUM_TELEPHONE);
                String grade=curseur.getString(NUM_COL_GRADE);
                String date_creation=curseur.getString(NUM_DATE_CREATION);
                developpeur developpeur = new developpeur(nom, prenom,domaine_developpement,niveau_etude,technologies, environnement, mail,"", telephone, grade);
                developpeur.setDate_creation(date_creation);
                developpeur.setId_developpeur(id);
                // resultat[i]=developpeur.toString();
                devs[i]=developpeur;
                i++;
                tweets.add(developpeur);
            }while (curseur.moveToNext());


        }


        curseur.close();
        return tweets;
    }
    public String[] getAllIDS(){
        String[] resultat=new String[50];
        Integer i=0;
        String req="select * from developpeur";
        Cursor curseur = bdd.rawQuery(req,null);
        curseur.moveToFirst();
        if(!curseur.isAfterLast())
        {
            do{
                Integer id=curseur.getInt(NUM_COL_ID);
                 resultat[i]=id.toString();
                //devs[i]=developpeur;
                i++;

            }while (curseur.moveToNext());


        }


        curseur.close();
        return resultat;
    }
    public developpeur[] getAllDeveloppeurs2(){
        String[] resultat=new String[50];
        developpeur[] devs=new developpeur[50];
        List<developpeur> tweets = new ArrayList<developpeur>();
//resultat[0]="f";
        Integer i=0;
        Cursor c = bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION}, COL_ID + " = 1", null, null, null, null);
        String req="select * from developpeur";
        Cursor curseur = bdd.rawQuery(req,null);
        curseur.moveToFirst();
        if(!curseur.isAfterLast())
        {
            do{
                Integer id=curseur.getInt(NUM_COL_ID);
                String nom=curseur.getString(NUM_COL_NOM);
                String prenom=curseur.getString(NUM_COL_PRENOM);
                String domaine_developpement=curseur.getString(NUM_COL_DOMAINE_DEVELOPPEMENT);
                String niveau_etude=curseur.getString(NUM_NIVEAU_ETUDE);
                String technologies=curseur.getString(NUM_COL_THECHNOLOGIES);
                String environnement=curseur.getString(NUM_COL_ENVIRONNEMENT);
                String mail=curseur.getString(NUM_COL_MAIL);
                String telephone=curseur.getString(NUM_TELEPHONE);
                String grade=curseur.getString(NUM_COL_GRADE);
                String date_creation=curseur.getString(NUM_DATE_CREATION);
                developpeur developpeur = new developpeur(nom, prenom,domaine_developpement,niveau_etude,technologies, environnement, mail,"", telephone, grade);
                developpeur.setDate_creation(date_creation);
                developpeur.setId_developpeur(id);
                // resultat[i]=developpeur.toString();
                devs[i]=developpeur;
                i++;
                tweets.add(developpeur);
            }while (curseur.moveToNext());


        }


        curseur.close();
        return devs;
    }

    private developpeur cursorToLivre(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
        { return null;}

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        developpeur developpeur = new developpeur();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        developpeur.setId_developpeur(c.getInt(NUM_COL_ID));
        developpeur.setNom(c.getString(NUM_COL_NOM));
        developpeur.setPrenom(c.getString(NUM_COL_PRENOM));
        developpeur.setDomaine_developpement(c.getString(NUM_COL_DOMAINE_DEVELOPPEMENT));
        developpeur.setNiveau_etude(c.getString(NUM_NIVEAU_ETUDE));
        developpeur.setTechnologies(c.getString(NUM_COL_THECHNOLOGIES));
        developpeur.setEnvironnement(c.getString(NUM_COL_ENVIRONNEMENT));
        developpeur.setMail(c.getString(NUM_COL_MAIL));
        developpeur.setTelephone(c.getString(NUM_TELEPHONE));
        developpeur.setGrade(c.getString(NUM_COL_GRADE));
        developpeur.setDate_creation(c.getString(NUM_DATE_CREATION));
        //On ferme le cursor
        c.close();

        return developpeur;
    }
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
     public long insertProjet(Projet projet){
         //Création d'un ContentValues (fonctionne comme une HashMap)
         ContentValues values0 = new ContentValues();
         //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
         values0.put(COL_NOM_projet, projet.getNom_projet());
         values0.put(COL_DETAIL, projet.getDetail());
         values0.put(COL_RECHERCHE, projet.getRecherche());
         values0.put(COL_ID_AUTEUR, projet.getId_auteur());



         //on insère l'objet dans la BDD via le ContentValues
         return bdd.insert(TABLE_projet, null, values0);
     }


     /********Partie Visiteur*******/
     public long insertVisiteur(Visiteur visiteur){
         //Création d'un ContentValues (fonctionne comme une HashMap)
         ContentValues values = new ContentValues();
         //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
         values.put(COL_NOM_visiteur, visiteur.getNom());
         values.put(COL_PRENOM_visiteur, visiteur.getPrenom());
         values.put(COL_NOM_entreprise_visiteur, visiteur.getNom_entreprise());
         values.put(COL_responsable_rh_visiteur, visiteur.getResponsable_rh());
         values.put(COL_telephone_visiteur, visiteur.getTelephone());
         values.put(COL_MAIL_visiteur, visiteur.getMail());
         values.put(COL_PASSWORD_visiteur, visiteur.getPassword());
         values.put(COL_type_visiteur, visiteur.getType());

         //on insère l'objet dans la BDD via le ContentValues
         return bdd.insert(TABLE_visiteur, null, values);
     }
     public Visiteur getVisiteur(String mail, String password)
     {
         //Cursor c= bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION},  "mail=\""+mail+"\" and password=\""+password+"\"", null, null, null, null);
         Cursor cursor = bdd.rawQuery("select * from visiteur   where mail = ?  AND  password = ? " , new String[]{mail, password });

         return cursorToVisiteur(cursor);
     }
     private Visiteur cursorToVisiteur(Cursor c){
         //si aucun élément n'a été retourné dans la requête, on renvoie null
         if (c.getCount() == 0)
         { return null;}

         //Sinon on se place sur le premier élément
         c.moveToFirst();
         //On créé un livre
         Visiteur visiteur = new Visiteur();
         //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
         visiteur.setId_visiteur(c.getInt(NUM_COL_ID_visiteur));
         visiteur.setNom(c.getString(NUM_COL_NOM_visiteur));
         visiteur.setPrenom(c.getString(NUM_COL_PRENOM_visiteur));
         visiteur.setNom_entreprise(c.getString(NUM_COL_NOM_entreprise_visiteur));
         visiteur.setResponsable_rh(c.getString(NUM_responsable_rh_visiteur));
         visiteur.setTelephone(c.getString(NUM_TELEPHONE));
         visiteur.setType(c.getString(NUM_COL_type_visiteur));
         visiteur.setDate_creation(c.getString(NUM_DATE_CREATION_visiteur));
         //On ferme le cursor
         c.close();

         return visiteur;
     }
     /********Partie Notification*******/
     public long insertNotification(NotificationProjet notification){
         //Création d'un ContentValues (fonctionne comme une HashMap)
         ContentValues values = new ContentValues();
         //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
         values.put(COL_ID_Projet_notification, notification.getId_projet());
         values.put(COL_ID_Developpeur_notification, notification.getId_developpeur());

         //on insère l'objet dans la BDD via le ContentValues
         return bdd.insert(TABLE_notification, null, values);
     }
     public NotificationProjet getNotificationProjet(String id_developpeur, String id_projet)
     {
         //Cursor c= bdd.query(TABLE_dev, new String[] {COL_ID,COL_NOM, COL_PRENOM,COL_DOMAINE_DEVELOPPEMENT,COL_ENVIRONNEMENT,COL_NIVEAU_ETUDE,COL_THECHNOLOGIES,COL_TELEPHONE,COL_MAIL,COL_GRADE,COL_DATE_CREATION},  "mail=\""+mail+"\" and password=\""+password+"\"", null, null, null, null);
         Cursor cursor = bdd.rawQuery("select * from notification_projet   where id_projet = ?  AND  id_developpeur = ? " , new String[]{id_projet, id_developpeur });

         return cursorToNotificaton(cursor);
     }
     private NotificationProjet cursorToNotificaton(Cursor c){
         //si aucun élément n'a été retourné dans la requête, on renvoie null
         if (c.getCount() == 0)
         { return null;}

         //Sinon on se place sur le premier élément
         c.moveToFirst();
         //On créé un livre
         NotificationProjet notification = new NotificationProjet();
         //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
         notification.setId_notification(c.getInt(NUM_COL_ID_notification));
         notification.setId_projet(c.getString(NUM_ID_Projet_notification));
         notification.setId_developpeur(c.getString(NUM_ID_Developpeur_notification));
         notification.setDate_creation(c.getString(NUM_date_creation_notification));
         //On ferme le cursor
         c.close();

         return notification;
     }
}