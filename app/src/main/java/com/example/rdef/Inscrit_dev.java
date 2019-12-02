package com.example.rdef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rdef.Entity.developpeur;
import com.example.rdef.controleur.DeveloppeurBDD;

public class Inscrit_dev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrit_dev);
        Button inscription = findViewById(R.id.inscription_dev);
        final EditText nom =  (EditText)findViewById(R.id.nom_dev);
        final TextView prenom = (TextView) findViewById(R.id.prenom);
        final TextView domaine_dev = (TextView) findViewById(R.id.domaine_dev);
        final TextView tech = (TextView) findViewById(R.id.technologie);
        final TextView environnement = (TextView) findViewById(R.id.environement);
        final TextView niveau_etude = (TextView) findViewById(R.id.niveau_etude);
        final TextView mail = (TextView) findViewById(R.id.mail);
        final TextView password = (TextView) findViewById(R.id.password);
        final RadioButton Junior =(RadioButton)this.findViewById(R.id.junior);
        final RadioButton Senior =(RadioButton)this.findViewById(R.id.Senior);
        final RadioButton Expert =(RadioButton)this.findViewById(R.id.Expert);
         String grade_dev="Junior";
        final developpeur developpeur=new developpeur();
        final DeveloppeurBDD developpeurBDD=new DeveloppeurBDD(this);
        final Intent myintent=new Intent(this,Session_dev.class);

                //Expert.setOnCheckedChangeListener(new RadioButton.)

        Expert.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                developpeur.setGrade("Expert");
               // Toast.makeText(Inscrit_dev.this, "non "+developpeur.getGrade(), Toast.LENGTH_LONG).show();
            }
        });
        Junior.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                developpeur.setGrade("Junior");
               // Toast.makeText(Inscrit_dev.this, "non "+developpeur.getGrade(), Toast.LENGTH_LONG).show();
            }
        });
        Senior.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                developpeur.setGrade("Senior");
                // Toast.makeText(Inscrit_dev.this, "non "+developpeur.getGrade(), Toast.LENGTH_LONG).show();
            }
        });
      //  Toast.makeText(this, "non "+developpeur.toString(), Toast.LENGTH_LONG).show();
        // TextView prenom = (TextView) findViewById(R.id.prenom);
inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 if(nom.getText().toString()==""||nom.getText().toString()==null||nom.getText().toString().length()==0)
                {
                    nom.setError("Champ invalide");
                    return;}
                    if(prenom.getText().toString()==""||prenom.getText().toString()==null||prenom.getText().toString().length()==0)
                    {prenom.setError("Champ invalide");return;}

                    if (tech.getText().toString() == ""||tech.getText().toString()==null||tech.getText().toString().length()==0) {
                        tech.setError("Champ invalide");return;
                    }
                    if (environnement.getText().toString() == ""||environnement.getText().toString()==null||environnement.getText().toString().length()==0) {
                        environnement.setError("Champ invalide");return;
                    }
                if(domaine_dev.getText().toString()==""||domaine_dev.getText().toString()==null||domaine_dev.getText().toString().length()==0)
                {domaine_dev.setError("Champ invalide");return;}
                if(mail.getText().toString()==""||mail.getText().toString().indexOf("@")<0||mail.getText().toString()==null||mail.getText().toString().length()==0)
                {mail.setError("Champ invalide");return;}
                if(password.getText().toString()==""||password.getText().toString()==null||password.getText().toString().length()==0)
                {password.setError("Champ invalide");return;}
                if(niveau_etude.getText().toString()==""||niveau_etude.getText().toString()==null||niveau_etude.getText().toString().length()==0)
                {niveau_etude.setError("Champ invalide");return;}

        developpeur.setNom(nom.getText().toString());
        developpeur.setPrenom(prenom.getText().toString());
        developpeur.setDomaine_developpement(domaine_dev.getText().toString());
        developpeur.setTechnologies(tech.getText().toString());
        developpeur.setEnvironnement(environnement.getText().toString());
        developpeur.setNiveau_etude(niveau_etude.getText().toString());
        developpeur.setMail(mail.getText().toString());
        developpeur.setPassword(password.getText().toString());
        developpeur.setTelephone("");
        //developpeur developpeur4= new developpeur("Sophie","Sophie","Web","bac +2","HTML, php","VisuelCode","ttt@gmail.com","123456","0123456789","junior");

        developpeurBDD.open();
        float o=developpeurBDD.insertDeveloppeur(developpeur);

       developpeur d=developpeurBDD.getDev(developpeur.getMail(),developpeur.getPassword());
               Toast.makeText(Inscrit_dev.this,"id_developpeur"+ d.getId_developpeur(), Toast.LENGTH_LONG).show();

                myintent.putExtra("id_developpeur",d.getId_developpeur());
                myintent.putExtra("nom",developpeur.getNom());
        myintent.putExtra("prenom",developpeur.getPrenom());
        myintent.putExtra("domaine_developpement",developpeur.getDomaine_developpement());
        myintent.putExtra("environnement",developpeur.getEnvironnement());
        myintent.putExtra("technologies",developpeur.getTechnologies());
        myintent.putExtra("grade",developpeur.getGrade());
        myintent.putExtra("niveau_etude",developpeur.getNiveau_etude());
        myintent.putExtra("mail",developpeur.getMail());
                developpeurBDD.close();
        startActivity(myintent);
       // finishAffinity();
       // Toast.makeText(Inscrit_dev.this, developpeur.toString(), Toast.LENGTH_LONG).show();

    }
});



    }
}
