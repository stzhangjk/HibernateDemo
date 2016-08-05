import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Grady on 2016.3.31.
 */
@Entity
@DiscriminatorValue("teacher")
public class Teacher extends Person{

    private int title;

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
