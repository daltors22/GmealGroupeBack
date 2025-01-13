package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photos")
    private Integer idPhotos;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "plats_id_plat", nullable = false)
    private Plats plat;

    // Getters et Setters
    public Integer getIdPhotos() {
        return idPhotos;
    }

    public void setIdPhotos(Integer idPhotos) {
        this.idPhotos = idPhotos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Plats getPlat() {
        return plat;
    }

    public void setPlat(Plats plat) {
        this.plat = plat;
    }
}
