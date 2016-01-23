package impl1;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Grady on 2016.1.18.
 */
@Embeddable
public class ScoreID implements Serializable{
    private int sid;
    private int cid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreID scoreID = (ScoreID) o;

        if (sid != scoreID.sid) return false;
        return cid == scoreID.cid;

    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + cid;
        return result;
    }
}
