package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom_restaurant", nullable = false)
    private String nomRestaurant;

    @Column(name = "temps_prep_moyen", nullable = false)
    private Integer tempsPrepMoyen;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "Adresse_Id", nullable = false)
    private Integer adresseId;

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public Integer getTempsPrepMoyen() {
        return tempsPrepMoyen;
    }

    public void setTempsPrepMoyen(Integer tempsPrepMoyen) {
        this.tempsPrepMoyen = tempsPrepMoyen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Integer adresseId) {
        this.adresseId = adresseId;
    }
}
