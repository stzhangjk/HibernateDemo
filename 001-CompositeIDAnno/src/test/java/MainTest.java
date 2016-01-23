
import impl3.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Grady on 2016.1.18.
 */
public class MainTest {

    private static SessionFactory sf = null;

    @BeforeClass
    public static void beforeClass(){
        Configuration con = new AnnotationConfiguration();
        sf = con.configure().buildSessionFactory();

    }

    @Test
    public void testStudent(){
        Session session = sf.openSession();
        session.beginTransaction();


        Student stu = new Student();
        stu.setName("Tom");
        stu.setAge(22);
        stu.setDepart("math");
        stu.setCla("01");
        session.save(stu);

        session.getTransaction().commit();
        session.close();
    }

    @AfterClass
    public static void afterClass(){

        sf.close();
    }
}
