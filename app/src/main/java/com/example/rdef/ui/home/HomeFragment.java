package com.example.rdef.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rdef.Accueil;
import com.example.rdef.DetailDeveloppeurs;
import com.example.rdef.Detailsprojet;
import com.example.rdef.DevAdapter;
import com.example.rdef.Entity.Projet;
import com.example.rdef.Entity.developpeur;
import com.example.rdef.ProjetAdapter;
import com.example.rdef.Projets;
import com.example.rdef.R;
import com.example.rdef.Session_dev;
import com.example.rdef.Session_visiteur;
import com.example.rdef.controleur.DeveloppeurBDD;

public class HomeFragment extends Fragment {
    //Context homeFragment_context=getActivity().getApplicationContext();
    ListView mListView;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        boolean myDataFromActivity_visiteur=false;
        boolean myDataFromActivity_dev=false;

        try {
            Session_visiteur session_visiteur = (Session_visiteur) getActivity();
            myDataFromActivity_visiteur = session_visiteur.session;
        }catch (Exception e){}

       // Toast.makeText(getContext(), "visiteur "+myDataFromActivity_visiteur, Toast.LENGTH_LONG).show();
        try {
            Session_dev session_dev = (Session_dev) getActivity();
            myDataFromActivity_dev = session_dev.session;
        }catch (Exception e){}
      //  Toast.makeText(getContext(), "dev "+myDataFromActivity_dev, Toast.LENGTH_LONG).show();

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //ViewGroup parent = (ViewGroup) root.getParent();
        //parent.removeView(root);

        //final TextView textView = root.findViewById(R.id.text_home);
        if(myDataFromActivity_visiteur){
            DeveloppeurBDD developpeurBDD= new DeveloppeurBDD(getContext());

            developpeurBDD.open();
          /*  final developpeur developpeur= new developpeur("Antoine","Antoine","Mobile","bac +3","Java, Kotlin","Android Studio","antoine@gmail.com","123456","0123456789","junior");
            developpeur developpeur2= new developpeur("Benameur","hichem","Web","bac +4","php, NodeJs, Javascript","VisuelCode","hichembenameur2003@gmail.com","000012","0751526593","junior");
            developpeur developpeur3= new developpeur("Gerard","Gerard","Mobile","bac +5","Java, IOS","Android Studio","Gerard@gmail.com","123456","0123456789","junior");
            developpeur developpeur4= new developpeur("Sophie","Sophie","Web","bac +2","HTML, php","VisuelCode","Sophie@gmail.com","123456","0123456789","junior");

            developpeurBDD.insertDeveloppeur(developpeur);
            developpeurBDD.insertDeveloppeur(developpeur2);
            developpeurBDD.insertDeveloppeur(developpeur3);
            developpeurBDD.insertDeveloppeur(developpeur4);*/
            //final String[] alldevs=developpeurBDD.getAllIDS();
            final  developpeur[] alldevs=developpeurBDD.getAllDeveloppeurs2();
            //Toast.makeText(this, "non "+tdt, Toast.LENGTH_LONG).show();
            //developpeur developpeurFromBdd = developpeurBDD.getLivreWithTitre(developpeur.getPrenom());

            mListView = (ListView) root.findViewById(R.id.listView);
            DevAdapter adapter = new DevAdapter(getContext(), developpeurBDD.getAllDeveloppeurs());
            mListView.setAdapter(adapter);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> adapterView,
                                        View view, int position, long id) {

                    Intent myintenet = new Intent(getContext(), DetailDeveloppeurs.class);
                    developpeur developpeur1 =alldevs[position];
                    myintenet.putExtra("id_visiteur",getActivity().getIntent().getExtras().getInt("id_visiteur"));

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
        }
        else if(myDataFromActivity_dev)
        {
            DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(getContext());
            developpeurBDD.open();

         /*   final Projet projet= new Projet("Portail Inscription","Vous","Développeur Web qui maitrise PHP et Javascript ","1");
            final Projet projet2= new Projet("Gestion de Stocks","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur C#/.net/JAVA  ","1");
            final Projet projet3= new Projet("Application mobile de vente","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur mobile qui maitrise java/android studio","1");
            final Projet projet4= new Projet("Maintenance de notre site Web","Vous devez, dans un premier temps, candidater selon les procédures et calendriers présentés sur ce site. Les candidatures formulées en dehors de ce cadre ne sont pas recevables.","Développeur Web qui maitrise HTML et NodeJs ","1");

            developpeurBDD.open();
            long tdt=developpeurBDD.insertProjet(projet);
            developpeurBDD.insertProjet(projet2);
            developpeurBDD.insertProjet(projet3);
            developpeurBDD.insertProjet(projet4);*/

            final  Projet[] allprojets=developpeurBDD.getAllProjets2();

            mListView = (ListView) root.findViewById(R.id.listView);
            ProjetAdapter adapter = new ProjetAdapter(getContext(), developpeurBDD.getAllProjets());
            mListView.setAdapter(adapter);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> adapterView,
                                        View view, int position, long id) {

                    Intent myintenet = new Intent(getContext(), Detailsprojet.class);
                    Projet projte1 =allprojets[position];

                    //Toast.makeText(getContext(), "id dev "+getI, Toast.LENGTH_LONG).show();
                   // Toast.makeText(getContext(), "prenom "+getActivity().getIntent().getExtras().getInt("id_developpeur"), Toast.LENGTH_LONG).show();

                    myintenet.putExtra("id_developpeur",getActivity().getIntent().getExtras().getInt("id_developpeur"));
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


        //final ListView mListView = (ListView) root.findViewById(R.id.listView);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });

      //  DeveloppeurBDD developpeurBDD = new DeveloppeurBDD(homeFragment_context);
        //developpeurBDD.open();


        return root;
    }


}