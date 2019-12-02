package com.example.rdef.Entity;

import java.sql.Timestamp;

public class developpeur {

        private int id_developpeur;
        private String nom;
        private String prenom;
        private String domaine_developpement;
        private String niveau_etude;
       // private String cv;
        private String technologies;
        private String environnement;
       // private String note;
        private String mail;
    private String password;
        private String telephone;
        private String grade;
        private String date_creation;

    public developpeur(){}

    // Constructeur
        public developpeur(String nom,
                           String prenom,
                           String domaine_developpement
                                   ,String niveau_etude
                                   ,String technologies
                                   ,String environnement
                                   ,String mail
                                    ,String password
                                   ,String telephone
                                   ,String grade
                                   ) {
           // this.id_developpeur=id;
            this.nom=nom;
            this.prenom=prenom;
            this.domaine_developpement=domaine_developpement;
            this.niveau_etude=niveau_etude;
          //  this.cv=cv;
            this.technologies=technologies;
            this.environnement=environnement;
           // this.note=note;
            this.mail=mail;
            this.password=password;

            this.telephone=telephone;
            this.grade=grade;
           // this.date_creation=date_creation;
        }

    public int getId_developpeur() {
        return id_developpeur;
    }

    public void setId_developpeur(int id_developpeur) {
        this.id_developpeur = id_developpeur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDomaine_developpement() {
        return domaine_developpement;
    }

    public void setDomaine_developpement(String domaine_developpement) {
        this.domaine_developpement = domaine_developpement;
    }

    public String getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "developpeur{" +
                "id_developpeur=" + id_developpeur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", domaine_developpement='" + domaine_developpement + '\'' +
                ", niveau_etude='" + niveau_etude + '\'' +
                ", technologies='" + technologies + '\'' +
                ", environnement='" + environnement + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", grade='" + grade + '\'' +
                ", date_creation=" + date_creation +
                '}';
    }
}
