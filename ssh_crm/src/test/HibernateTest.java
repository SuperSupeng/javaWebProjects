import dao.UserDao;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Test
    public void fun1() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        User u = new User();
        u.setUser_code("rose");
        u.setUser_name("露丝");
        u.setUser_password("1234");
        session.save(u);

        transaction.commit();
        session.close();
        sf.close();
    }

    @Test
    public void fun2() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        User u = new User();
        u.setUser_code("j哎哎哎");
        u.setUser_name("杰克");
        u.setUser_password("1235");
        session.save(u);

        transaction.commit();
        session.close();
    }

    private UserDao ud;
    @Test
    public void fun3() {
        User u = ud.getByUserCode("rose");
        System.out.println(u);
    }

    private UserService us;
    @Test
    public void fun4() {
        User u = new User();
        u.setUser_code("hqy");
        u.setUser_name("郝强勇");
        u.setUser_password("1234");
        us.saveUser(u);
    }

}
