package com.example.gestionprofil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualiserProfilActivity extends AppCompatActivity {

    private ImageView photo_profil;
    private TextView info_profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiser_profil);

        photo_profil = findViewById(R.id.photo_profil_visua);
        info_profil = findViewById(R.id.info);

        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREF_ID_PROFIL", MODE_PRIVATE);
        int id = sharedPreferences.getInt("SHARED_PREF_ID_PROFIL",1);

        info_profil.append("Id : "+id);

    }
}