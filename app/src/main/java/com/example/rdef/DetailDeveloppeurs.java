package com.example.rdef;

import android.content.Intent;
import android.os.Bundle;

import com.example.rdef.controleur.DeveloppeurBDD;
import com.example.rdef.Entity.developpeur;
import com.example.rdef.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailDeveloppeurs extends AppCompatActivity {
    private Button one, two, three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_developpeurs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String id =getIntent().getStringExtra("id");
        String nom =getIntent().getStringExtra("nom");
        String prenom =getIntent().getStringExtra("prenom");
        String domaine_developpement =getIntent().getStringExtra("domaine_developpement");
        String environnement =getIntent().getStringExtra("environnement");
        String technologies =getIntent().getStringExtra("technologies");
        String grade =getIntent().getStringExtra("grade");
        String niveau_etude =getIntent().getStringExtra("niveau_etude");


        TextView pseudo = (TextView)findViewById(R.id.pseudo0);
        pseudo.setText(prenom+" "+nom+" (Developpeur "+grade+")");
        TextView text1 = (TextView)findViewById(R.id.text1);
        text1.setText("Domaine de développement: "+domaine_developpement);
        TextView text2 = (TextView)findViewById(R.id.text2);
        text2.setText("Thechnologies: "+technologies);
        TextView text3 = (TextView)findViewById(R.id.text3);
        text3.setText("Environement de developpemnt: "+environnement);
        TextView text4 = (TextView)findViewById(R.id.text4);
        text4.setText("Niveau d'étude: "+niveau_etude);
        //convertView.setText(nom);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Vous êtes intéressé par ce profil et vous souhaitez le contacter ?", 1000000)
                        .setAction("OUI",
                                new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
    Toast.makeText(DetailDeveloppeurs.this, "Notification Envoyée", Toast.LENGTH_LONG).show();
                                        //Intent launchactivity= new Intent(DetailDeveloppeurs.this, LoginActivity.class);
                                      //  startActivity(launchactivity);
                                    }}).show();
            }
        });


    }

}
