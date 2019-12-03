package com.example.rdef.ui.gallery;

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

import com.example.rdef.DetailProjet;
import com.example.rdef.Detailsprojet;
import com.example.rdef.Entity.Projet;
import com.example.rdef.ProjetAdapter;
import com.example.rdef.R;
import com.example.rdef.controleur.DeveloppeurBDD;

public class GalleryFragment extends Fragment {
    ListView mListView;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
      //  final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
              //  textView.setText(s);
            }
        });
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

        //final  Projet[] allprojets=developpeurBDD.getAllProjets2();
        final  Projet[] allprojets2=developpeurBDD.getAllProjetsByVisiteur(Integer.toString(getActivity().getIntent().getExtras().getInt("id_visiteur")));
        //Toast.makeText(getContext(), "id "+getActivity().getIntent().getExtras().getInt("id_visiteur"), Toast.LENGTH_LONG).show();

        mListView = (ListView) root.findViewById(R.id.listView3);
        ProjetAdapter adapter = new ProjetAdapter(getContext(), developpeurBDD.getAllProjetsByVisiteur2(Integer.toString(getActivity().getIntent().getExtras().getInt("id_visiteur"))));
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                Intent myintenet = new Intent(getContext(), DetailProjet.class);
                Projet projte1 =allprojets2[position];

                //Toast.makeText(getContext(), "id dev "+getI, Toast.LENGTH_LONG).show();
                // Toast.makeText(getContext(), "prenom "+getActivity().getIntent().getExtras().getInt("id_developpeur"), Toast.LENGTH_LONG).show();

              //  myintenet.putExtra("id_developpeur",getActivity().getIntent().getExtras().getInt("id_developpeur"));
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
        return root;
    }
}