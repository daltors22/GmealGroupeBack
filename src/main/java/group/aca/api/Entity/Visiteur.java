package group.aca.api.Entity;


import jakarta.persistence.*;

//@Entity
@Table(name = "visiteur")
public class Visiteur {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private static Integer id;

    public Visiteur() {
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Visiteur.id = id;
    }

   @Column(name = "actions")
    private String actions;

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

//    @Column(name = "date")
//    private String date;
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
}
