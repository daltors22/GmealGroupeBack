package group.aca.api.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_action")
    private Integer idAction;

    @Column(name = "nom_action")
    private String nomAction;

    @Column(name = "description")
    private String description;

    @Column(name = "date_action")
    private LocalDate dateAction;

    @Column(name = "User_Id")
    private Integer userId;

    // Getters et Setters
    public Integer getIdAction() {
        return idAction;
    }

    public void setIdAction(Integer idAction) {
        this.idAction = idAction;
    }

    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAction() {
        return dateAction;
    }

    public void setDateAction(LocalDate dateAction) {
        this.dateAction = dateAction;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
