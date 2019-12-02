package com.example.rdef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.rdef.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetailProjet extends AppCompatActivity {
    private Button one, two, three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_projet);
      //  Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       /* String id =getIntent().getStringExtra("id_projet");
        String nom_projet =getIntent().getStringExtra("nom_projet");
        String detail =getIntent().getStringExtra("detail");
        String recherche =getIntent().getStringExtra("recherche");
        String id_auteur =getIntent().getStringExtra("id_auteur");
        String date_creation =getIntent().getStringExtra("date_creation");



        TextView pseudo = (TextView)findViewById(R.id.pseudo0);
        pseudo.setText(nom_projet);

        TextView text2 = (TextView)findViewById(R.id.text2);
        text2.setText(detail);
        TextView text3 = (TextView)findViewById(R.id.text3);
        text3.setText(recherche);
        TextView text5 = (TextView)findViewById(R.id.text5);
        text5.setText("Crée le : "+date_creation+" par ");
        //convertView.setText(nom);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Authentification obligatoire pour continuer", 1000000)
                        .setAction("Se connecter",
                                new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        Intent launchactivity= new Intent(DetailProjet.this, LoginActivity.class);
                                        startActivity(launchactivity); }}).show();
            }
        });

*/
    }

}
