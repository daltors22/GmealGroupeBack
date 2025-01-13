package group.aca.api.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "commandes")
public class Commandes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande")
    private Integer idCommande;

    @Column(name = "date_commande", nullable = false)
    private LocalDateTime dateCommande;

    @Column(name = "status_commande", nullable = false)
    private String statusCommande;

    @Column(name = "date_livraison")
    private LocalDateTime dateLivraison;

    @Column(name = "User_id", nullable = false)
    private Integer userId;

    @Column(name = "distance", nullable = false)
    private Integer distance;

    @Column(name = "poids", nullable = false)
    private Integer poids;

    @Column(name = "frais", nullable = false)
    private Double frais;

    // Getters et Setters
    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatusCommande() {
        return statusCommande;
    }

    public void setStatusCommande(String statusCommande) {
        this.statusCommande = statusCommande;
    }

    public LocalDateTime getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDateTime dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Double getFrais() {
        return frais;
    }

    public void setFrais(Double frais) {
        this.frais = frais;
    }
}
