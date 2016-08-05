import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Grady on 2016.1.21.
 */
public class Test003 {

    private static SessionFactory sf = null;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration();
        sf = con.configure().buildSessionFactory();
    }

    @Test
    public void test3Status(){
        Book book = new Book();
        //transient态，内存中的一个对象，没有ID，缓存中的也没有
        book.setName("book");

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(book);
         //persistent态，内存中有，session缓存中有,数据库有，ID有
        System.out.println(111);
        session.getTransaction().commit();
        //detached态，内存中有，Session缓存没有，数据库也有
}

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
