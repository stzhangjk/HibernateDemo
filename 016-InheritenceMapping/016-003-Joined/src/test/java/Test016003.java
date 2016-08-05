import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class Test016003 {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void test(){

        {
            Session session = sf.getCurrentSession();
            session.beginTransaction();
            Student student = new Student();
            student.setName("s1");
            student.setScore(100);

            session.save(student);

            session.getTransaction().commit();
        }

        {
            Session session = sf.getCurrentSession();
            session.beginTransaction();


            Person p = (Person) session.load(Person.class, 1);
            System.out.println(p.getName());

            session.getTransaction().commit();
        }

    }


    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
