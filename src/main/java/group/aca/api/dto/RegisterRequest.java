package group.aca.api.dto;

import group.aca.api.Entity.User;
import group.aca.api.Entity.Ville;

public class RegisterRequest {
    private String nom;
    private String prenom;
    private String telephone;
    private User.TypeUtilisateur typeUtilisateur; // Utilisation de l'enum
    private String email;
    private String motDePasse;
    // Rajouter defaut = false/true
    private String adresse;
    private String rue;
    private Integer Ville_id_ville;
    private Integer user_id;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getVille_id_ville() {
        return Ville_id_ville;
    }

    public void setVille_id_ville(Integer ville_id_ville) {
        Ville_id_ville = ville_id_ville;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
