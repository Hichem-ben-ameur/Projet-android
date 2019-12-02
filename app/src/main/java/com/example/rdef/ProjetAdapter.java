package com.example.rdef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rdef.Entity.Projet;
import com.example.rdef.Entity.developpeur;

import java.util.List;

public class ProjetAdapter extends ArrayAdapter<Projet> {

    //tweets est la liste des models à afficher
    public ProjetAdapter(Context context, List<Projet> projets) {
        super(context, 0, projets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView =  LayoutInflater.from(getContext()).inflate(R.layout.row_projet,parent, false);
        }

        ProjetAdapter.TweetViewHolder viewHolder = (ProjetAdapter.TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ProjetAdapter.TweetViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Projet projet = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.pseudo.setText(projet.getNom_projet());
        viewHolder.text.setText(projet.getRecherche());
        // viewHolder.avatar.setImageDrawable(new ColorDrawable(tweet.getColor()));

        return convertView;
    }

    private class TweetViewHolder{
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;
    }
}
