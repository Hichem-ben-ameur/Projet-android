package com.example.rdef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rdef.Entity.Projet;
import com.example.rdef.Entity.Visiteur;
import com.example.rdef.Entity.developpeur;
import com.example.rdef.controleur.DeveloppeurBDD;
import com.example.rdef.ui.login.LoginActivity;
import com.example.rdef.ui.login.LoginActivity2;

public class Choix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix);
        final Button Button_dev = findViewById(R.id.button_dev);
        final Button Button_entreprise = findViewById(R.id.button_entreprise);
       // final Intent intent = new Intent(this, Inscrit_dev.class);
        DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(this);


        final Projet projet= new Projet("Portail Inscription","Vous","Développeur Web qui maitrise PHP et Javascript ","2");
        final Projet projet2= new Projet("Gestion de Stocks","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur C#/.net/JAVA  ","1");
        final Projet projet3= new Projet("Application mobile de vente","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur mobile qui maitrise java/android studio","1");
        final Projet projet4= new Projet("Maintenance de notre site Web","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur Web qui maitrise HTML et NodeJs ","1");

        developpeurBDD.open();
        long tdt=developpeurBDD.insertProjet(projet);
        developpeurBDD.insertProjet(projet2);
        developpeurBDD.insertProjet(projet3);
        developpeurBDD.insertProjet(projet4);
        final developpeur developpeur= new developpeur("Antoine","Antoine","Mobile","bac +3","Java, Kotlin","Android Studio","antoine@gmail.com","123456","0123456789","junior");
        developpeur developpeur2= new developpeur("Benameur","hichem","Web","bac +4","php, NodeJs, Javascript","VisuelCode","hichembenameur2003@gmail.com","000012","0751526593","junior");
        developpeur developpeur3= new developpeur("Gerard","Gerard","Mobile","bac +5","Java, IOS","Android Studio","Gerard@gmail.com","123456","0123456789","junior");
        developpeur developpeur4= new developpeur("Sophie","Sophie","Web","bac +2","HTML, php","VisuelCode","Sophie@gmail.com","123456","0123456789","junior");
        Visiteur visiteur= new Visiteur("", "Entreprise", "", "CGI", "Olivier", "cgi@gmail.com", "000012", "") ;
developpeurBDD.insertVisiteur(visiteur);
        developpeurBDD.insertDeveloppeur(developpeur);
        developpeurBDD.insertDeveloppeur(developpeur2);
        developpeurBDD.insertDeveloppeur(developpeur3);
        developpeurBDD.insertDeveloppeur(developpeur4);
        developpeurBDD.close();
         final Intent intent = new Intent(this, LoginActivity.class);

        final Intent intent2 = new Intent(this, LoginActivity2.class);
        Button_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("session","dev");
                startActivity(intent);
            }
        });
        Button_entreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("session","entreprise");
                startActivity(intent2);
            }
        });

    }

}
