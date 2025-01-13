package group.aca.api.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promotion")
    private Integer idPromotion;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "reduction", nullable = false)
    private Double reduction;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "Restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Getters et Setters
    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
