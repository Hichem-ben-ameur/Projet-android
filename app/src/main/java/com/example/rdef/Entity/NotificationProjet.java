package com.example.rdef.Entity;

public class NotificationProjet {
    private int id_notification;
    private String id_projet;
    private String id_developpeur;
    private String date_creation;

    public NotificationProjet() { }

    public NotificationProjet(int id_notification, String id_projet, String id_developpeur, String date_creation) {
        this.id_notification = id_notification;
        this.id_projet = id_projet;
        this.id_developpeur = id_developpeur;
        this.date_creation = date_creation;
    }

    public int getId_notification() {
        return id_notification;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
    }

    public String getId_projet() {
        return id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getId_developpeur() {
        return id_developpeur;
    }

    public void setId_developpeur(String id_developpeur) {
        this.id_developpeur = id_developpeur;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }
}
