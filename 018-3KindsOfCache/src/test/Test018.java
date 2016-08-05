import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Grady on 2016.4.25.
 */
public class Test018 {
    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void insertData(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        for(int i=0;i<100;i++){
            Category c = new Category();
            c.setName("c" + i);
            session.save(c);
        }

        session.getTransaction().commit();
    }


    @Test
    public void testCache(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        Category category = (Category)session.get(Category.class,1);
        System.out.println(category.getId());
        session.getTransaction().commit();

        Session s = sf.getCurrentSession();
        s.beginTransaction();

        Category c = (Category)s.get(Category.class,1);
        System.out.println(c.getId());
        s.getTransaction().commit();

    }

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
