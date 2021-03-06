package dao.impl;

import dao.TempDataDao;
import domain.TempData;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtils;

import java.util.Date;
import java.util.List;

/**
 * @author super
 */
public class TempDataDaoImpl implements TempDataDao {


    @Override
    public void save(TempData tempData) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(tempData);
        transaction.commit();
    }

    @Override
    public TempData findById(String id) {
        Session session = HibernateUtils.getCurrentSession();
        Criteria criteria = session.createCriteria(TempData.class);
        criteria.add(Restrictions.eq("id", id));
        return (TempData) criteria.uniqueResult();
    }

    @Override
    public List<TempData> findAllData(Date startDate, Date endDate, boolean isInverse) {
        Session session = HibernateUtils.getCurrentSession();
        String sql = "select * from tempt where dataDate>=? and dataDate<=? order by dataDate ?";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter(0, startDate);
        query.setParameter(1, endDate);
        if(isInverse){
            query.setParameter(2, "ASC");
        }else{
            query.setParameter(2, "DESC");
        }
        query.addEntity(TempData.class);
        List list = query.list();
        return list;
    }

    @Override
    public List<TempData> findAllData(Date startDate, Date endDate) {
        Session session = HibernateUtils.getCurrentSession();
        String sql = "select * from tempt where dataDate>=? and dataDate<=?";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter(0, startDate);
        query.setParameter(1, endDate);
        query.addEntity(TempData.class);
        List list = query.list();
        return list;
    }
}
