package com.example.gestionprofil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gestionprofil.Model.DatabaseHelper;
import com.example.gestionprofil.Model.Profil;
import java.util.ArrayList;
import java.util.List;

public class AfficherLesProfilActivity extends AppCompatActivity {

    private static final String SHARED_PREF_ID_PROFIL = "SHARED_PREF_ID_PROFIL";
    private static final int REQUEST_CODE_VISUALISER_PROFIL = 44;
    private TextView profil;
    private List<Profil> listeProfil = new ArrayList<>();
    private final DatabaseHelper databaseHelper = new DatabaseHelper(AfficherLesProfilActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_les_profil);

        profil = findViewById(R.id.profil);

        listeProfil.addAll(databaseHelper.getAllProfil());

        for(Profil p : listeProfil) {

            profil.append(p.getId()+p.getPrenom()+"\n");

            profil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(AfficherLesProfilActivity.this,VisualiserProfilActivity.class);
                    startActivityForResult(intent,REQUEST_CODE_VISUALISER_PROFIL);
                }
            });
        }

    }
}