package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String adresse;
    private String detail;
    private String rue;

    @Column(name = "Ville_id_ville")
    private Integer villeId;

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

    public Integer getVilleId() {
        return villeId;
    }

    public void setVilleId(Integer villeId) {
        this.villeId = villeId;
    }
}
