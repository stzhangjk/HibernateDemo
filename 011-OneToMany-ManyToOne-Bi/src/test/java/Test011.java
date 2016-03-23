import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class Test011 {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void test(){

    }

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
