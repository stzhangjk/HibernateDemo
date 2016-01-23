import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

/**
 * Created by Grady on 2016.1.20.
 */
public class Main {

    public static void testStudent(){
        AnnotationConfiguration con = new AnnotationConfiguration();
        SessionFactory sf = con.configure().buildSessionFactory();
        Session session1 = sf.getCurrentSession();
        Session session2 = sf.getCurrentSession();
        System.out.println(session1 == session2);
        session1.beginTransaction();

        //-----------------

        session1.getTransaction().commit();

        Session session3 = sf.getCurrentSession();
        System.out.println(session1 == session3);
    }

    public static void main(String[] args){

        testStudent();

    }
}
