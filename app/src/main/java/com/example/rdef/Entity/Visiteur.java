package com.example.rdef.Entity;

public class Visiteur {
    private int id_visiteur;
    private String nom;
    private String type;
    private String prenom;
    private String nom_entreprise;
    private String responsable_rh;
    private String mail;
    private String password;
    private String telephone;
    private String date_creation;

    public Visiteur(String nom, String type, String prenom, String nom_entreprise, String responsable_rh, String mail, String password, String telephone) {
        this.nom = nom;
        this.type = type;
        this.prenom = prenom;
        this.nom_entreprise = nom_entreprise;
        this.responsable_rh = responsable_rh;
        this.mail = mail;
        this.password = password;
        this.telephone = telephone;
    }

    public Visiteur() { }

    public int getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(int id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getResponsable_rh() {
        return responsable_rh;
    }

    public void setResponsable_rh(String responsable_rh) {
        this.responsable_rh = responsable_rh;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }
}
