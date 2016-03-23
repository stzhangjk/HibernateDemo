import entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Grady on 2016.3.14.
 */
public class TestStudent {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void testUpdate(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        Student s = new Student();
        s.setName("1");
        session.save(s);


        session.getTransaction().commit();
    }


    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
