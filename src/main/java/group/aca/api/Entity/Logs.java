package group.aca.api.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Integer idLog;

    @Column(name = "niveau", nullable = false)
    private String niveau;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date_log", nullable = false)
    private LocalDateTime dateLog;

    @Column(name = "User_id", nullable = false)
    private Integer userId;

    // Getters and Setters
    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateLog() {
        return dateLog;
    }

    public void setDateLog(LocalDateTime dateLog) {
        this.dateLog = dateLog;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
