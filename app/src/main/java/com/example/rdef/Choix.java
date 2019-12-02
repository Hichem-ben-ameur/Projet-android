package com.example.rdef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rdef.ui.login.LoginActivity;
import com.example.rdef.ui.login.LoginActivity2;

public class Choix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix);
        final Button Button_dev = findViewById(R.id.button_dev);
        final Button Button_entreprise = findViewById(R.id.button_entreprise);
       // final Intent intent = new Intent(this, Inscrit_dev.class);
         final Intent intent = new Intent(this, LoginActivity.class);

        final Intent intent2 = new Intent(this, LoginActivity2.class);
        Button_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("session","dev");
                startActivity(intent);
            }
        });
        Button_entreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("session","entreprise");
                startActivity(intent2);
            }
        });

    }

}
