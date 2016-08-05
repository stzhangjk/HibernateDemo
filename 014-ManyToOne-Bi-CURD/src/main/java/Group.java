import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "_group")
public class Group {
    private int id;
    private String name;
    private Set<User> users = new HashSet<User>();

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


    @OneToMany(mappedBy = "group",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)          //双向映射加MappedBy避免冗余id
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
