import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Grady on 2016.3.22.
 */
public class TestOne2One {


    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void testUniFK(){

    }

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
