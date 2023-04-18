package com.example.gestionprofil.Model;

public class Profil {

    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String adresse;
    private String photoProfilPath;

    public Profil() {

    }

    public Profil(int id, String nom, String prenom, String pseudo, String adresse, String photoProfilPath) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.adresse = adresse;
        this.photoProfilPath = photoProfilPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhotoProfilPath() {
        return photoProfilPath;
    }

    public void setPhotoProfilPath(String photoProfilPath) {
        this.photoProfilPath = photoProfilPath;
    }
}
