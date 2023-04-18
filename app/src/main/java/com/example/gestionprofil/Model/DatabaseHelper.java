package com.example.gestionprofil.Model;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Test";
    private static final String TABLE_PROFIL = "Profil";
    private static final String COLUMN_PROFIL_ID = "profil_id";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_PRENOM = "prenom";
    private static final String COLUMN_PSEUDO = "pseudo";
    private static final String COLUMN_ADRESSE = "adresse";
    private static final String COLUMN_PHOTO_PROFIL = "photo_profil_path";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "DatabaseHelper.onCreate ...");

        String script = "CREATE TABLE "+ TABLE_PROFIL + "("
                + COLUMN_PROFIL_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NOM + " TEXT,"
                + COLUMN_PRENOM + " TEXT,"
                + COLUMN_PSEUDO + " TEXT,"
                + COLUMN_ADRESSE + " TEXT,"
                + COLUMN_PHOTO_PROFIL + " TEXT"+")";

        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG,"DatabaseHelper.onUpgrade ...");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROFIL);
        onCreate(db);
    }

    public void addProfil(Profil profil) {

        Log.i(TAG,"DatabaseHelper.addProfil ...");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_NOM,profil.getNom());
        values.put(COLUMN_PRENOM,profil.getPrenom());
        values.put(COLUMN_PSEUDO,profil.getPseudo());
        values.put(COLUMN_ADRESSE,profil.getAdresse());
        values.put(COLUMN_PHOTO_PROFIL,profil.getPhotoProfilPath());

        db.insert(TABLE_PROFIL,null,values);

        db.close();
    }

    public Profil getProfil(int id) {
        Log.i(TAG,"DatabaseHelper.getProfil ..."+id);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PROFIL,new String[] {COLUMN_PROFIL_ID
                        ,COLUMN_NOM,COLUMN_PRENOM,COLUMN_PSEUDO,COLUMN_ADRESSE,COLUMN_PHOTO_PROFIL},COLUMN_PROFIL_ID+"=?",
                new String[] { String.valueOf(id)},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();

        Profil profil = new Profil(Integer.parseInt(cursor.getString(0))
                ,cursor.getString(1)
                ,cursor.getString(2)
                ,cursor.getString(3)
                ,cursor.getString(4)
                ,cursor.getString(5));

        return profil;
    }

    public List<Profil> getAllProfil() {
        Log.i(TAG,"DatabaseHelper.getAllProfil ...");

        List<Profil> profilListe = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+TABLE_PROFIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()) {

            do {
                Profil profil = new Profil();
                profil.setId(Integer.parseInt(cursor.getString(0)));
                profil.setNom(cursor.getString(1));
                profil.setPrenom(cursor.getString(2));
                profil.setPseudo(cursor.getString(3));
                profil.setAdresse(cursor.getString(4));
                profil.setPhotoProfilPath(cursor.getString(5));
                profilListe.add(profil);
            }while (cursor.moveToNext());
        }
        return profilListe;
    }

    public int getProfilCount() {
        Log.i(TAG,"DatabaseHelper.getProfilCount ...");

        String countQuery = "SELECT * FROM "+TABLE_PROFIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);

        int count = cursor.getCount();

        cursor.close();

        return count;
    }
}
