package com.example.rdef;

import android.content.Intent;
import android.os.Bundle;

import com.example.rdef.Entity.Livre;
import com.example.rdef.Entity.Projet;
import com.example.rdef.Entity.developpeur;
import com.example.rdef.controleur.DeveloppeurBDD;
import com.example.rdef.controleur.LivresBDD;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Projets extends AppCompatActivity {
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projets);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(this);


        final Projet projet= new Projet("Portail Inscription","Vous","Développeur Web qui maitrise PHP et Javascript ","1");
        final Projet projet2= new Projet("Gestion de Stocks","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur C#/.net/JAVA  ","1");
        final Projet projet3= new Projet("Application mobile de vente","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur mobile qui maitrise java/android studio","1");
        final Projet projet4= new Projet("Maintenance de notre site Web","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur Web qui maitrise HTML et NodeJs ","1");

        developpeurBDD.open();
        long tdt=developpeurBDD.insertProjet(projet);
        developpeurBDD.insertProjet(projet2);
        developpeurBDD.insertProjet(projet3);
        developpeurBDD.insertProjet(projet4);

        final  Projet[] allprojets=developpeurBDD.getAllProjets2();

        mListView = (ListView) findViewById(R.id.listView);
        ProjetAdapter adapter = new ProjetAdapter(Projets.this, developpeurBDD.getAllProjets());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                Intent myintenet = new Intent(Projets.this,Detailsprojet.class);
                Projet projte1 =allprojets[position];
                myintenet.putExtra("id_projet",projte1.getId_projet()+"");
                myintenet.putExtra("nom_projet",projte1.getNom_projet());
                myintenet.putExtra("detail",projte1.getDetail());
                myintenet.putExtra("recherche",projte1.getRecherche());
                myintenet.putExtra("id_auteur",projte1.getId_auteur());
                myintenet.putExtra("date_creation",projte1.getDate_creation());

                startActivity(myintenet);
            }
        });
        developpeurBDD.close();

    }

}
