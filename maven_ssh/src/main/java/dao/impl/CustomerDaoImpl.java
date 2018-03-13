package dao.impl;

import dao.CustomerDao;
import entity.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @author super
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public Customer findById(Long id) {
        return this.getHibernateTemplate().get(Customer.class, id);
    }
}
