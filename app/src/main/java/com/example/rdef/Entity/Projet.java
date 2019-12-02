package com.example.rdef.Entity;

public class Projet {
    private int id_projet;
    private String nom_projet;
    private String detail;
    private String recherche;
    private String id_auteur;
    private String date_creation;


    public Projet(String nom_projet, String detail, String recherche, String id_auteur) {
        this.nom_projet = nom_projet;
        this.detail = detail;
        this.recherche = recherche;
        this.id_auteur = id_auteur;
    }

    public Projet() { }

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public String getNom_projet() {
        return nom_projet;
    }

    public void setNom_projet(String nom_projet) {
        this.nom_projet = nom_projet;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRecherche() {
        return recherche;
    }

    public void setRecherche(String recherche) {
        this.recherche = recherche;
    }

    public String getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(String id_auteur) {
        this.id_auteur = id_auteur;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }
}
