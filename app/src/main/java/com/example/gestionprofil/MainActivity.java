package com.example.gestionprofil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PROFIL_ACTIVITY = 42;
    private static final int REQUEST_CODE_VISUALISER_PROFIL = 43;
    private Button creerCompte;
    private Button visualiserLesComptes;

    private Button cours;

    private Button quizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creerCompte = findViewById(R.id.creer_compte);
        visualiserLesComptes = findViewById(R.id.visualiser);
        cours = findViewById(R.id.cours);
        quizz = findViewById(R.id.quizz);

        creerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProfilActivity.class);
                startActivityForResult(intent,REQUEST_CODE_PROFIL_ACTIVITY);
            }
        });

        visualiserLesComptes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AfficherLesProfilActivity.class);
                startActivityForResult(intent,REQUEST_CODE_VISUALISER_PROFIL);
            }
        });

        quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(intent,REQUEST_CODE_VISUALISER_PROFIL);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CoursActivity.class);
                startActivityForResult(intent,REQUEST_CODE_VISUALISER_PROFIL);
            }
        });


    }
}