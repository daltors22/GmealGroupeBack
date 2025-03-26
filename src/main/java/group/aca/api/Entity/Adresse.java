package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // même que l'ID du user, donc pas @GeneratedValue

    private String adresse;
    private String detail;
    private String rue;

    @ManyToOne
    @JoinColumn(name = "Ville_id_ville", referencedColumnName = "id_ville")
    private Ville ville;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "Id")
    private User user;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
