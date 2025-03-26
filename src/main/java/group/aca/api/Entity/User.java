package group.aca.api.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user") // Nom de la table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Correspond à la colonne en base
    private Integer id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;

    @Column(name = "telephone", length = 45)
    private String telephone;

    @Enumerated(EnumType.STRING) // Pour mapper l'ENUM
    @Column(name = "typeUtilisateur", nullable = false)
    private TypeUtilisateur typeUtilisateur;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @ManyToOne
    @JoinColumn(name = "adresse_id", referencedColumnName = "Id")
    private Adresse adresse;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public TypeUtilisateur getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSessionToken(Object o) {
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    // Enum pour le typeUtilisateur
    public enum TypeUtilisateur {
        client,
        restaurant,
        livreur,
        admin
    }

    public class RegisterRequest {
        private String nom;
        private String prenom;
        private String telephone;
        private String typeUtilisateur;
        private String email;
        private String motDePasse;

        // Getters et setters
    }

}

