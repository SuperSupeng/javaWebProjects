package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sf;

    static{
        Configuration conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
    }

    public static Session openSession(){
        //3 获得session
        Session session = sf.openSession();

        return session;

    }

    public static Session getCurrentSession(){
        //3 获得session
        Session session = sf.getCurrentSession();

        return session;
    }
}
