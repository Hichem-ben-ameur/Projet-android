package com.example.rdef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.rdef.Entity.NotificationProjet;
import com.example.rdef.controleur.DeveloppeurBDD;
import com.example.rdef.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetailProjet extends AppCompatActivity {
    NotificationProjet notificationProjet = new NotificationProjet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsprojet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String id =getIntent().getStringExtra("id_projet");
        final int id_developpeur =getIntent().getExtras().getInt("id_developpeur");
        String nom_projet =getIntent().getStringExtra("nom_projet");
        String detail =getIntent().getStringExtra("detail");
        String recherche =getIntent().getStringExtra("recherche");
        String id_auteur =getIntent().getStringExtra("id_auteur");
        String date_creation =getIntent().getStringExtra("date_creation");
        final DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(DetailProjet.this);
        developpeurBDD.open();
        NotificationProjet n=developpeurBDD.getNotificationProjet(Integer.toString(id_developpeur),id);
        //Toast.makeText(Detailsprojet.this, "n :"+n.toString(), Toast.LENGTH_LONG).show();

        notificationProjet.setId_projet(id);
        notificationProjet.setId_developpeur(Integer.toString(id_developpeur));


        TextView pseudo = (TextView)findViewById(R.id.pseudo0);
        pseudo.setText(nom_projet);

        TextView text2 = (TextView)findViewById(R.id.text2);
        text2.setText(detail);
        TextView text3 = (TextView)findViewById(R.id.text3);
        text3.setText(recherche);
        TextView text5 = (TextView)findViewById(R.id.text5);
        text5.setText(""+date_creation+"");
        //convertView.setText(nom);
        // FloatingActionButton fab2 = findViewById(R.id.fab2);




    }

}
