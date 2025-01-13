package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "livreur")
public class Livreur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_livreur")
    private Integer idLivreur;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "vehicule", nullable = false)
    private String vehicle;

    // Getters and Setters
    public Integer getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(Integer idLivreur) {
        this.idLivreur = idLivreur;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
