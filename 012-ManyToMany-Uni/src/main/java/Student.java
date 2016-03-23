import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grady on 2016.3.23.
 */

@Entity
public class Student {
    private int id;
    private String name;
    private Set<Teacher> teachers = new HashSet<Teacher>();

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

    @ManyToMany
    @JoinTable(
        name = "t_s",
        joinColumns = {
            @JoinColumn(name = "sid")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "tid")
        }
    )
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
