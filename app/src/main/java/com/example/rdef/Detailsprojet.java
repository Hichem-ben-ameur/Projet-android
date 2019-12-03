package com.example.rdef;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import com.example.rdef.Entity.NotificationProjet;
import com.example.rdef.controleur.DeveloppeurBDD;
import com.example.rdef.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Detailsprojet extends AppCompatActivity {
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
        final DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(Detailsprojet.this);
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
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.show();
         fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Vous êtes intéressé par ce projet et vous souhaitez contacter la société ?", 1000000)
                        .setAction("OUI",
                                new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        //  Toast.makeText(Detailsprojet.this, "id dev"+id_developpeur, Toast.LENGTH_LONG).show();
                                        // Toast.makeText(Detailsprojet.this, "id dev"+id_developpeur, Toast.LENGTH_LONG).show();



                                        developpeurBDD.insertNotification(notificationProjet);
                                        developpeurBDD.open();
                                        Toast.makeText(Detailsprojet.this, "Notification Envoyée", Toast.LENGTH_LONG).show();
                                        fab.hide();
                                        // Intent launchactivity= new Intent(Detailsprojet.this, LoginActivity.class);
                                        //  startActivity(launchactivity);
                                    }}).show();
            }
        });
       if (n!=null){
            fab.hide();

           Toast.makeText(Detailsprojet.this, "Vous avez déjà postuler pour ce projet !", Toast.LENGTH_LONG).show();

       }



    }

}
