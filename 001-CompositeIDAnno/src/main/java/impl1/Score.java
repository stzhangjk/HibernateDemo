package impl1;

import javax.persistence.*;

/**
 * Created by Grady on 2016.1.18.
 */
@Entity
@Table(name="_Score")
public class Score {

    private ScoreID id;
    private int score;

    @Id
    public ScoreID getId() {
        return id;
    }

    public void setId(ScoreID id) {
        this.id = id;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
