package com.example.rdef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rdef.Entity.developpeur;

import java.util.List;

public class DevAdapter  extends  ArrayAdapter<developpeur> {

        //tweets est la liste des models à afficher
        public DevAdapter(Context context, List<developpeur> devs) {
            super(context, 0, devs);
        }

        @Override
        public  View getView(int position, View convertView,  ViewGroup parent) {

            if(convertView == null){
                convertView =  LayoutInflater.from(getContext()).inflate(R.layout.row_developpeur,parent, false);
            }

            TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new TweetViewHolder();
                viewHolder.pseudo = ( TextView) convertView.findViewById(R.id.pseudo);
                viewHolder.text = (TextView) convertView.findViewById(R.id.text);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
                convertView.setTag(viewHolder);
            }

            //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
            developpeur developpeur = getItem(position);

            //il ne reste plus qu'à remplir notre vue
            viewHolder.pseudo.setText(developpeur.getPrenom());
            viewHolder.text.setText(developpeur.getDomaine_developpement()+"("+developpeur.getTechnologies()+")");
           // viewHolder.avatar.setImageDrawable(new ColorDrawable(tweet.getColor()));

            return convertView;
        }

        private class TweetViewHolder{
            public TextView pseudo;
            public TextView text;
            public ImageView avatar;
        }
    }
