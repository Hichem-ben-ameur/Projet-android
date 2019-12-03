package com.example.rdef;

import com.example.rdef.Entity.developpeur;
import com.example.rdef.controleur.DeveloppeurBDD;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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


        DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(this);


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


    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.session_dev2, menu);
        return true;
    }*/

}