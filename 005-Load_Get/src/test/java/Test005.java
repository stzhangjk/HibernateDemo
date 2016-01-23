import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Grady on 2016.1.21.
 */
public class Test005 {
    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        sf = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @Test
    public void testLoad(){
        Book book = new Book();
        book.setName("book1");

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        session = sf.getCurrentSession();
        session.beginTransaction();
        Book b = (Book)session.load(Book.class, 1);     //代理对象
        System.out.println(b.getId()+b.getName());      //发出Sql语句
        System.out.println(b.getClass());
        session.getTransaction().commit();

    }

    @Test
    public void testGet(){
        Book book = new Book();
        book.setName("book1");

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        session = sf.getCurrentSession();
        session.beginTransaction();
        Book b = (Book)session.get(Book.class, 1);          //sql发出
        //System.out.println(b.getId()+b.getName());          //完整对象
        session.getTransaction().commit();
        System.out.println(b.getId() + b.getName());
        System.out.println(b.getClass());
    }

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
