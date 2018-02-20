package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    private static Configuration conf;
    private static SessionFactory sf;
    private static Session session;

    static{
        conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
    }

    //获得session => 获得全新session
    public static Session openSession(){
        session = sf.openSession();
        return session;

    }
    //获得session => 获得与线程绑定的session
    public static Session getCurrentSession(){
        session = sf.getCurrentSession();
        return session;
    }
}
