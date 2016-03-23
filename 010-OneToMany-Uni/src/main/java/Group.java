import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grady on 2016.3.23.
 */
@Entity
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
    @OneToMany
    @JoinColumn(name = "groupId")           //不加则当做多对多处理，生成中间表
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
