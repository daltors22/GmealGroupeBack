package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "typecuisine")
public class TypeCuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuisine")
    private Integer idCuisine;

    @Column(name = "nom_cuisine", nullable = false)
    private String nomCuisine;

    @Column(name = "description")
    private String description;

    // Getters et Setters
    public Integer getIdCuisine() {
        return idCuisine;
    }

    public void setIdCuisine(Integer idCuisine) {
        this.idCuisine = idCuisine;
    }

    public String getNomCuisine() {
        return nomCuisine;
    }

    public void setNomCuisine(String nomCuisine) {
        this.nomCuisine = nomCuisine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
