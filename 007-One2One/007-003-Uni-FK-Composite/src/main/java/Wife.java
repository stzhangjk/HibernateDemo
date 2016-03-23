import javax.persistence.*;

/**
 * Created by Grady on 2016.3.22.
 */
@Entity
@IdClass(WifeId.class)
public class Wife {
    private int id;
    private String name;
    private Husband husband;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "hid")
    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
