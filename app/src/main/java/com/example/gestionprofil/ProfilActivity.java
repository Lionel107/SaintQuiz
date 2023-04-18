package com.example.gestionprofil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gestionprofil.Model.DatabaseHelper;
import com.example.gestionprofil.Model.Profil;

import java.io.File;
import java.io.FileOutputStream;

public class ProfilActivity extends AppCompatActivity {

    private EditText prenom;
    private EditText nom;
    private EditText pseudo;
    private EditText adresse;
    private ImageView photoProfil;
    private Button ajoutePhotoProfil;
    private Button creerProfil;
    private String fileName;

    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;

    private final DatabaseHelper databaseHelper = new DatabaseHelper(ProfilActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        prenom = findViewById(R.id.prenom);
        nom = findViewById(R.id.nom);
        pseudo = findViewById(R.id.pseudo);
        adresse = findViewById(R.id.adresse);
        photoProfil = findViewById(R.id.photo_profil);

        ajoutePhotoProfil = findViewById(R.id.ajoute_photo);
        creerProfil = findViewById(R.id.creer_profil);



        ajoutePhotoProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                captureImage();
            }
        });

        creerProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prenomP = prenom.getText().toString();
                String nomP = nom.getText().toString();
                String pseudoP = pseudo.getText().toString();
                String adresseP = adresse.getText().toString();
                creerProfil(new Profil(databaseHelper.getProfilCount(),prenomP,nomP,pseudoP,adresseP,fileName));
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                this.photoProfil.setImageBitmap(bp);

                int count = databaseHelper.getProfilCount();

                fileName = "image"+count+".jng";

                File dir = getApplicationContext().getDir("images", Context.MODE_PRIVATE);
                File file = new File(dir, fileName);
                FileOutputStream fileOutputStream = null;

                try {
                    fileOutputStream = new FileOutputStream(file);
                    bp.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
                editor.putString("image_path", file.getAbsolutePath());
                editor.apply();

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void captureImage() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
    }

    private void creerProfil(Profil profil) {
        databaseHelper.addProfil(profil);
    }

}