package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Grady on 2016.1.18.
 */

public class Score {

    private ScoreID id;
    private int score;


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
