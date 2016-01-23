package impl1;

import javax.persistence.*;

/**
 * Created by Grady on 2016.1.18.
 */
@Entity
@Table(name="_Course")
public class Course {
    private int id;
    private String name;
    private int credit;

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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
