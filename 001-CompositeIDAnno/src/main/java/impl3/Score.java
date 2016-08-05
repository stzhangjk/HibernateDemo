package impl3;



import javax.persistence.*;

/**
 * Created by Grady on 2016.1.18.
 */
@Entity
@Table(name="_Score")
@IdClass(impl3.ScoreID.class)
public class Score {

    private int sid;
    private int cid;
    private int score;

    @Id
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
    @Id
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
