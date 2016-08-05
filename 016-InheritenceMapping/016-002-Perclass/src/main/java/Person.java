import javax.persistence.*;

/**
 * Created by Grady on 2016.3.31.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name = "t_gen",
        table = "t_gen_table",
        pkColumnName = "t_pk",
        pkColumnValue = "person_pk",
        valueColumnName = "t_value",
        initialValue = 1,
        allocationSize = 1
)
public class Person {

    private int id;
    private String name;

    @Id
    @GeneratedValue(generator = "t_gen", strategy = GenerationType.TABLE)
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
