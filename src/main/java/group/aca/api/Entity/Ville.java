package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ville") // Correspond à "id_ville" dans la base
    private Integer idVille;

    @Column(name = "name", nullable = false) // Correspond à "name" dans la base
    private String name;

    @Column(name = "codePostal", nullable = false) // Correspond à "codePostal" dans la base
    private Integer codePostal;

    // Getters
    public Integer getIdVille() {
        return idVille;
    }

    public String getName() {
        return name;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    // Setters
    public void setIdVille(Integer idVille) {
        this.idVille = idVille;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }
}
