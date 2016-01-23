package impl3;

import javax.persistence.*;

/**
 * Created by Grady on 2016.1.18.
 */

@Entity
@Table(name="_Student")
public class Student {
    private int id;
    private String name;
    private int age;
    private String depart;
    private String cla;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    @Column(name="class")
    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
}
