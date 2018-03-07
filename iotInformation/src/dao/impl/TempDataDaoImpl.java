package dao.impl;

import dao.TempDataDao;
import domain.TempData;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtils;

import java.util.Date;
import java.util.List;

public class TempDataDaoImpl implements TempDataDao {


    @Override
    public void save(TempData tempData) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(tempData);
    }

    @Override
    public TempData findById(String id) {
        Session session = HibernateUtils.getCurrentSession();
        Criteria criteria = session.createCriteria(TempData.class);
        criteria.add(Restrictions.eq("id", id));
        return (TempData) criteria.uniqueResult();
    }

    @Override
    public List<TempData> findAllData() {
        Session session = HibernateUtils.getCurrentSession();
        Criteria criteria = session.createCriteria(TempData.class);
        return criteria.list();
    }

    @Override
    public List<TempData> findAllData(Date startDate, Date endDate, boolean isInverse) {
        Session session = HibernateUtils.getCurrentSession();
        String sql = "select * from tempt where dataDate>=? and dataDate<=?";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter(0, startDate);
        query.setParameter(1, endDate);
        return null;
    }
}
