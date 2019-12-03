package com.example.rdef.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rdef.Entity.Projet;
import com.example.rdef.R;
import com.example.rdef.controleur.DeveloppeurBDD;
import com.example.rdef.ui.gallery.GalleryFragment;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
       // final TextView textView = root.findViewById(R.id.text_slideshow);
        final Button insertion = root.findViewById(R.id.insert_projet);
        final TextView nom_projet = (TextView) root.findViewById(R.id.titre);
        final TextView details_projet = (TextView) root.findViewById(R.id.details);
        final TextView recherche_projet = (TextView) root.findViewById(R.id.recherche);
        final TextView insert_succ = root.findViewById(R.id.Insertion_succ);
       final DeveloppeurBDD developpeurBDD= new DeveloppeurBDD(getContext());
        nom_projet.setVisibility(View.VISIBLE);
        details_projet.setVisibility(View.VISIBLE);
        recherche_projet.setVisibility(View.VISIBLE);
        insertion.setVisibility(View.VISIBLE);
        insert_succ.setVisibility(View.GONE);
        developpeurBDD.open();
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        insertion.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Inscrit_visiteur.this, " "+nom.getText().toString().length(), Toast.LENGTH_LONG).show();


                if(nom_projet.getText().toString()==""||nom_projet.getText().toString()==null||nom_projet.getText().toString().length()==0)
                {nom_projet.setError("Champ invalide");return;}
                if(details_projet.getText().toString()==""||details_projet.getText().toString()==null||details_projet.getText().toString().length()==0)
                {details_projet.setError("6 caractères minimum");return;}
                if(recherche_projet.getText().toString()==""||recherche_projet.getText().toString()==null||recherche_projet.getText().toString().length()==0)
                {recherche_projet.setError("Champ invalide");return;}
                Projet projet = new Projet();
                projet.setNom_projet(nom_projet.getText().toString());
                projet.setDetail(details_projet.getText().toString());
                projet.setRecherche(recherche_projet.getText().toString());
                projet.setId_auteur(Integer.toString(getActivity().getIntent().getExtras().getInt("id_visiteur")));


                //developpeur developpeur4= new developpeur("Sophie","Sophie","Web","bac +2","HTML, php","VisuelCode","ttt@gmail.com","123456","0123456789","junior");


                float o=developpeurBDD.insertProjet(projet);
                developpeurBDD.close();
                //Intent myintent=new Intent(getContext(), GalleryFragment.class);
nom_projet.setVisibility(View.GONE);
                details_projet.setVisibility(View.GONE);
                recherche_projet.setVisibility(View.GONE);
                insertion.setVisibility(View.GONE);
                insert_succ.setVisibility(View.VISIBLE);

                //startActivity(myintent);
                //Toast.makeText(Inscrit_visiteur.this, " "+o, Toast.LENGTH_LONG).show();


            }
        });
        return root;
    }
}