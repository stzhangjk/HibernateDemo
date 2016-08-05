import javax.persistence.*;

/**
 * Created by Grady on 2016.3.31.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    private int id;
    private String name;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
