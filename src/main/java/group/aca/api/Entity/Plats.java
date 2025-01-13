package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "plats")
public class Plats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plat")
    private Integer idPlat;

    @Column(name = "nom_plat", nullable = false)
    private String nomPlat;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "poids", nullable = false)
    private Integer poids;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    @Column(name = "Restaurant_id", nullable = false)
    private Integer restaurantId;

    // Getters et Setters
    public Integer getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(Integer idPlat) {
        this.idPlat = idPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
