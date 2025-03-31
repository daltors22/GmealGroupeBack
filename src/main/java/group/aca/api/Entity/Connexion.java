package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "connexion")
public class Connexion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_connexion")
    private Integer idConnexion;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "User_Id") // Correspondance explicite avec la colonne
    private Integer userId;

    // Getters et Setters
    public Integer getIdConnexion() {
        return idConnexion;
    }

    public void setIdConnexion(Integer idConnexion) {
        this.idConnexion = idConnexion;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {


        this.motDePasse = motDePasse;

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
