import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class Test013 {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void test(){
        Student s = new Student();
        s.setName("s1");

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();

    }

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
