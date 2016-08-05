
import javax.persistence.Entity;

/**
 * Created by Grady on 2016.3.31.
 */
@Entity
public class Student extends Person{

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
