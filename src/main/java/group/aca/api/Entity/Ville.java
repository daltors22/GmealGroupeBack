package group.aca.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class Ville {

    @Id
    @Column(name = "id_ville", length = 10)
    private String idVille; // Code INSEE (ex: "60159")

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "codePostal", nullable = false)
    private String codePostal; // Souvent traité comme string pour gérer les CP DOM (ex: 97100)

    // Getters
    public String getIdVille() {
        return idVille;
    }

    public String getName() {
        return name;
    }

    public String getCodePostal() {
        return codePostal;
    }


    // Setters
    public void setIdVille(String idVille) {
        this.idVille = idVille;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
