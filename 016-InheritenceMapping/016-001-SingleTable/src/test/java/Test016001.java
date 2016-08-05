import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class Test016001 {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void test(){
        Person person = new Person();
        person.setName("person");

        {
            Session session = sf.getCurrentSession();
            session.beginTransaction();

            session.save(person);

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
