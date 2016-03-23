import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grady on 2016.3.23.
 */

@Entity
public class Teacher {
    private int id;
    private String name;
    private Set<Student> students = new HashSet<Student>();


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


    @ManyToMany(mappedBy = "teachers")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
