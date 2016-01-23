import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Grady on 2016.1.21.
 */

public class Test004 {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        sf = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @Test
    public void testDelete(){
        Book book = new Book();
        book.setName("book1");

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        System.out.println(000);
        session = sf.getCurrentSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
    }

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
