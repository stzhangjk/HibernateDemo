import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class Test014 {

    private static SessionFactory sf;

    @BeforeClass
    public static void beforeClass(){
        AnnotationConfiguration con = new AnnotationConfiguration().configure();
        sf = con.buildSessionFactory();
    }

    @Test
    public void testSaveUser(){

        User user = new User();
        user.setName("user1");
        Group group = new Group();
        group.setName("group1");

        user.setGroup(group);
        group.getUsers().add(user);

        Session session = sf.getCurrentSession();
        session.beginTransaction();

//        session.save(group);              //自动保存
        session.save(user);

        session.getTransaction().commit();
    }

    @Test
    public void testSaveGroup(){

        User user = new User();
        user.setName("user1");
        User user1 = new User();
        user1.setName("user2");

        Group group = new Group();
        group.setName("group1");

        user1.setGroup(group);
        user.setGroup(group);
        group.getUsers().add(user);
        group.getUsers().add(user1);

        Session session = sf.getCurrentSession();
        session.beginTransaction();

        session.save(group);              //自动保存
//        session.save(user);

        session.getTransaction().commit();
    }

    @Test
    public void testGetUser(){
        testSaveGroup();

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        User user = (User)session.get(User.class,1);
        session.getTransaction().commit();
        System.out.println(user.getGroup().getName());
    }

    @Test
    public void testGetGroup(){
        testSaveGroup();

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Group group = (Group)session.get(Group.class,1);
        session.getTransaction().commit();

        for (User u : group.getUsers()){
            System.out.println(u.getName());
        }
    }

    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}
