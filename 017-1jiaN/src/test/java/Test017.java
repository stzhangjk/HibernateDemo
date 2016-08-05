import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Grady on 2016.4.17.
 */
public class Test017 {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void test(){

        Session session = sf.getCurrentSession();
        session.beginTransaction();

        for(int i=0;i<10;i++){
            Category category = new Category();
            category.setName("c" + i);
            Topic topic = new Topic();
            topic.setCategory(category);
            topic.setCreateDate(new Date());
            topic.setTitle("t" + i);

            session.save(category);
            session.save(topic);
        }

        session.getTransaction().commit();

    }

    //1+N
    @Test
    public void testQuery(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        //问题出现
        List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();

        //问题解决方案1：left outer join
        //List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();


        //方法2：@BatchSize



        for(Topic t : topics){
            System.out.println(t.getId() +"-"+ t.getTitle());
        }

        session.getTransaction().commit();
    }


    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
