package com.example.rdef;

import androidx.appcompat.app.AppCompatActivity;
import com.example.rdef.Entity.Livre;
import com.example.rdef.Entity.developpeur;
import com.example.rdef.controleur.DeveloppeurBDD;
import com.example.rdef.controleur.LivresBDD;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends Activity {
    public static final developpeur connected_dev=null;
    ListView mListView;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Création d'une instance de ma classe LivresBDD
        LivresBDD livreBdd = new LivresBDD(this);
        DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(this);

        //Création d'un livre
        Livre livre = new Livre("123456789", "Programmez pour Android");
        final developpeur developpeur= new developpeur("Antoine","Antoine","Mobile","bac +3","Java, Kotlin","Android Studio","antoine@gmail.com","123456","0123456789","junior");
        developpeur developpeur2= new developpeur("Benameur","hichem","Web","bac +4","php, NodeJs, Javascript","VisuelCode","hichembenameur2003@gmail.com","000012","0751526593","junior");
        developpeur developpeur3= new developpeur("Gerard","Gerard","Mobile","bac +5","Java, IOS","Android Studio","Gerard@gmail.com","123456","0123456789","junior");
        developpeur developpeur4= new developpeur("Sophie","Sophie","Web","bac +2","HTML, php","VisuelCode","Sophie@gmail.com","123456","0123456789","junior");

        developpeurBDD.open();
        developpeurBDD.insertDeveloppeur(developpeur);
        developpeurBDD.insertDeveloppeur(developpeur2);
        developpeurBDD.insertDeveloppeur(developpeur3);
        developpeurBDD.insertDeveloppeur(developpeur4);
//final String[] alldevs=developpeurBDD.getAllIDS();
final  developpeur[] alldevs=developpeurBDD.getAllDeveloppeurs2();
        //Toast.makeText(this, "non "+tdt, Toast.LENGTH_LONG).show();
        //developpeur developpeurFromBdd = developpeurBDD.getLivreWithTitre(developpeur.getPrenom());

        mListView = (ListView) findViewById(R.id.listView);
        DevAdapter adapter = new DevAdapter(MainActivity.this, developpeurBDD.getAllDeveloppeurs());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                        Intent myintenet = new Intent(MainActivity.this,DetailDeveloppeurs.class);
developpeur developpeur1 =alldevs[position];
                myintenet.putExtra("id",developpeur1.getId_developpeur()+"");
                myintenet.putExtra("nom",developpeur1.getNom());
                myintenet.putExtra("prenom",developpeur1.getPrenom());
                myintenet.putExtra("domaine_developpement",developpeur1.getDomaine_developpement());
                myintenet.putExtra("environnement",developpeur1.getEnvironnement());
                myintenet.putExtra("technologies",developpeur1.getTechnologies());
                myintenet.putExtra("grade",developpeur1.getGrade());
                myintenet.putExtra("niveau_etude",developpeur1.getNiveau_etude());

                        startActivity(myintenet);
            }
        });
        developpeurBDD.close();
        //On ouvre la base de données pour écrire dedans
       /* livreBdd.open();
        //On insère le livre que l'on vient de créer
        livreBdd.insertLivre(livre);

        //Pour vérifier que l'on a bien créé notre livre dans la BDD
        //on extrait le livre de la BDD grâce au titre du livre que l'on a créé précédemment
        Livre livreFromBdd = livreBdd.getLivreWithTitre(livre.getTitre());
        //Si un livre est retourné (donc si le livre à bien été ajouté à la BDD)
        if(livreFromBdd != null){
            //On affiche les infos du livre dans un Toast
            Toast.makeText(this, livreFromBdd.toString(), Toast.LENGTH_LONG).show();
            //On modifie le titre du livre
            livreFromBdd.setTitre("J'ai modifié le titre du livre");
            //Puis on met à jour la BDD
            livreBdd.updateLivre(livreFromBdd.getId(), livreFromBdd);
        }

        //On extrait le livre de la BDD grâce au nouveau titre
        livreFromBdd = livreBdd.getLivreWithTitre("J'ai modifié le titre du livre");
        //S'il existe un livre possédant ce titre dans la BDD
        if(livreFromBdd != null){
            //On affiche les nouvelles informations du livre pour vérifier que le titre du livre a bien été mis à jour
            Toast.makeText(this, livreFromBdd.toString(), Toast.LENGTH_LONG).show();
            //on supprime le livre de la BDD grâce à son ID
            livreBdd.removeLivreWithID(livreFromBdd.getId());
        }

        //On essaye d'extraire de nouveau le livre de la BDD toujours grâce à son nouveau titre
        livreFromBdd = livreBdd.getLivreWithTitre("J'ai modifié le titre du livre");
        //Si aucun livre n'est retourné
        if(livreFromBdd == null){
            //On affiche un message indiquant que le livre n'existe pas dans la BDD
            Toast.makeText(this, "Ce livre n'existe pas dans la BDD", Toast.LENGTH_LONG).show();
        }
        //Si le livre existe (mais normalement il ne devrait pas)
        else{
            //on affiche un message indiquant que le livre existe dans la BDD
            Toast.makeText(this, "Ce livre existe dans la BDD", Toast.LENGTH_LONG).show();
        }

        livreBdd.close();*/

    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.session_dev2, menu);
        return true;
    }*/

}