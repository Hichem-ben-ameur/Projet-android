package com.example.rdef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rdef.Entity.Visiteur;
import com.example.rdef.controleur.DeveloppeurBDD;

public class Inscrit_visiteur extends AppCompatActivity {
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrit_visiteur);
        final RadioButton Particulier =(RadioButton)this.findViewById(R.id.Senior);
        final RadioButton Entreprise =(RadioButton)this.findViewById(R.id.Expert);
        final EditText nom =  (EditText)findViewById(R.id.nom_visiteur);
        final TextView prenom = (TextView) findViewById(R.id.prenom);
        final TextView tel = (TextView) findViewById(R.id.telephone);
        final TextView nom_entreprise = (TextView) findViewById(R.id.nom_entreprise);
        final TextView responsable_RH = (TextView) findViewById(R.id.responsable_RH);
        final TextView mail = (TextView) findViewById(R.id.mail);
        final TextView password = (TextView) findViewById(R.id.password);
        final Button inscription = findViewById(R.id.inscription_dev);
        final DeveloppeurBDD developpeurBDD=new DeveloppeurBDD(this);
        developpeurBDD.open();
        final Intent myintent=new Intent(this,Session_visiteur.class);


        Entreprise.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                nom_entreprise.setVisibility(View.VISIBLE);
                responsable_RH.setVisibility(View.VISIBLE);
                tel.setVisibility(View.VISIBLE);
                prenom.setVisibility(View.GONE);
                nom.setVisibility(View.GONE);
                inscription.setVisibility(View.VISIBLE);
                type="Entreprise";
     }
        });

        Particulier.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                prenom.setVisibility(View.VISIBLE);
                nom.setVisibility(View.VISIBLE);
                tel.setVisibility(View.VISIBLE);
                nom_entreprise.setVisibility(View.GONE);
                responsable_RH.setVisibility(View.GONE);
                inscription.setVisibility(View.VISIBLE);
                type="Particulier";
    }
        });
        inscription.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Inscrit_visiteur.this, " "+nom.getText().toString().length(), Toast.LENGTH_LONG).show();

                if(type=="Particulier")
                { if(nom.getText().toString()==""||nom.getText().toString()==null||nom.getText().toString().length()==0)
                {
                    nom.setError("Champ invalide");
                    return;}
                    if(prenom.getText().toString()==""||prenom.getText().toString()==null||prenom.getText().toString().length()==0)
                    {prenom.setError("Champ invalide");return;}
                }else {
                    if (nom_entreprise.getText().toString() == ""||nom_entreprise.getText().toString()==null||nom_entreprise.getText().toString().length()==0) {
                        nom_entreprise.setError("Champ invalide");return;
                    }
                    if (responsable_RH.getText().toString() == ""||responsable_RH.getText().toString()==null||responsable_RH.getText().toString().length()==0) {
                        responsable_RH.setError("Champ invalide");return;
                    }
                }
                if(mail.getText().toString()==""||mail.getText().toString().indexOf("@")<0||mail.getText().toString()==null||mail.getText().toString().length()==0)
                {mail.setError("Champ invalide");return;}
                if(password.getText().toString()==""||password.getText().toString()==null||password.getText().toString().length()==0)
                {password.setError("Champ invalide");return;}
                if(tel.getText().toString()==""||tel.getText().toString()==null||tel.getText().toString().length()==0)
                {tel.setError("Champ invalide");return;}
                Visiteur visiteur=new Visiteur();
                visiteur.setNom(nom.getText().toString());
                visiteur.setPrenom(prenom.getText().toString());
                visiteur.setNom_entreprise(nom_entreprise.getText().toString());
                visiteur.setResponsable_rh(responsable_RH.getText().toString());
                visiteur.setType(type);
                visiteur.setMail(mail.getText().toString());
                visiteur.setPassword(password.getText().toString());
                visiteur.setTelephone(tel.getText().toString());
                //developpeur developpeur4= new developpeur("Sophie","Sophie","Web","bac +2","HTML, php","VisuelCode","ttt@gmail.com","123456","0123456789","junior");


                float o=developpeurBDD.insertVisiteur(visiteur);
                developpeurBDD.close();
                myintent.putExtra("nom",visiteur.getNom());
                myintent.putExtra("prenom",visiteur.getPrenom());
                myintent.putExtra("type",visiteur.getType());
                myintent.putExtra("nom_entreprise",visiteur.getNom_entreprise());
                myintent.putExtra("responsable_rh",visiteur.getResponsable_rh());
                myintent.putExtra("tel",visiteur.getTelephone());
                myintent.putExtra("mail",visiteur.getMail());

                startActivity(myintent);
                finishAffinity();
                //Toast.makeText(Inscrit_visiteur.this, " "+o, Toast.LENGTH_LONG).show();


            }
        });
    }
}
