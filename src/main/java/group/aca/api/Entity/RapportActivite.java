package group.aca.api.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rapports_activite")
public class RapportActivite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rapport")
    private Integer idRapport;

    @Column(name = "type_rapport", nullable = false)
    private String typeRapport;

    @Column(name = "contenu", nullable = false)
    private String contenu;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation;

    @ManyToOne
    @JoinColumn(name = "administrateur_id_admin", nullable = false)
    private Administrateur administrateur;

    // Getters et Setters
    public Integer getIdRapport() {
        return idRapport;
    }

    public void setIdRapport(Integer idRapport) {
        this.idRapport = idRapport;
    }

    public String getTypeRapport() {
        return typeRapport;
    }

    public void setTypeRapport(String typeRapport) {
        this.typeRapport = typeRapport;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
}
