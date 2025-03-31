package group.aca.api.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private Integer idNotification;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date_envoi", nullable = false)
    private LocalDateTime dateEnvoi;

    @Column(name = "status_lecture", nullable = false)
    private Boolean statusLecture;

    @Column(name = "User_id", nullable = false)
    private Integer userId;

    @Column(name = "ActiveNotif")
    private Boolean activeNotif;

    // Getters et Setters
    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Boolean getStatusLecture() {
        return statusLecture;
    }

    public void setStatusLecture(Boolean statusLecture) {
        this.statusLecture = statusLecture;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // Getter & Setter
    public Boolean getActiveNotif() {
        return activeNotif;
    }

    public void setActiveNotif(Boolean activeNotif) {
        this.activeNotif = activeNotif;
    }
}
