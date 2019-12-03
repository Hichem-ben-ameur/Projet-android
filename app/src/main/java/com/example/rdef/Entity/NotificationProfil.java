package com.example.rdef.Entity;

public class NotificationProfil {
    private int id_notification;
    private String id_visiteur;
    private String id_developpeur;
    private String date_creation;

    public NotificationProfil() {    }

    public NotificationProfil(int id_notification, String id_visiteur, String id_developpeur, String date_creation) {
        this.id_notification = id_notification;
        this.id_visiteur = id_visiteur;
        this.id_developpeur = id_developpeur;
        this.date_creation = date_creation;
    }

    public int getId_notification() {
        return id_notification;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
    }

    public String getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(String id_visiteur) {
        this.id_visiteur = id_visiteur;
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

    @Override
    public String toString() {
        return "NotificationProfil{" +
                "id_notification=" + id_notification +
                ", id_visiteur='" + id_visiteur + '\'' +
                ", id_developpeur='" + id_developpeur + '\'' +
                ", date_creation='" + date_creation + '\'' +
                '}';
    }
}
