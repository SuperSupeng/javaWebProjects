package dao.impl;

import dao.LinkManDao;
import domain.LinkMan;
import org.hibernate.Session;
import utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {
    @Override
    public void save(LinkMan linkMan) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(linkMan);
    }
}
