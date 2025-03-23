package group.aca.api.dto;

import group.aca.api.Entity.User;

public class RegisterRequest {
    private String nom;
    private String prenom;
    private String telephone;
    private User.TypeUtilisateur typeUtilisateur; // Utilisation de l'enum
    private String email;
    private String motDePasse;

    // Getters et setters

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
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public User.TypeUtilisateur getTypeUtilisateur() {
        return typeUtilisateur;
    }
    public void setTypeUtilisateur(User.TypeUtilisateur typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
