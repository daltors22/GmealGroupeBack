package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;

    @Column(name = "préférence", nullable = true)
    private String preference;

    // Getters
    public Integer getIdClient() {
        return idClient;
    }

    public String getPreference() {
        return preference;
    }

    // Setters
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
