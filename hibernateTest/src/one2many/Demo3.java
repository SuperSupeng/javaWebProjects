package one2many;

import domain.Customer;
import domain.LinkMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import utils.HibernateUtils;

public class Demo3 {
    @Test
    public void fun1() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer c = new Customer();
        c.setCust_name("传智播");

        LinkMan lm1 = new LinkMan();
        lm1.setLkm_name("黎活明");

        LinkMan lm2 = new LinkMan();
        lm2.setLkm_name("刘悦东");

        //表达一对多,客户下有多个联系人
        c.getLinkMens().add(lm1);
        c.getLinkMens().add(lm2);

        //表达对对对,联系人属于哪个客户
        lm1.setCustomer(c);
        lm2.setCustomer(c);

        session.save(c);
        session.save(lm1);
        session.save(lm2);
        transaction.commit();

        session.close();
    }
}
