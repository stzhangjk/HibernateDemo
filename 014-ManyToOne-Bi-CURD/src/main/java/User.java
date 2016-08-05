import javax.persistence.*;


@Entity
@Table(name = "_user")
public class User {
    private int id;
    private String name;
    private Group group;

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

    //一的一方默认被取出
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "gid")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
