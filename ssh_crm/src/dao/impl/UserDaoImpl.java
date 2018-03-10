package dao.impl;

import dao.UserDao;
import domain.User;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public User getByUserCode(String userCode) {
        //HQL
        return getHibernateTemplate().execute(session -> {
            String hql = "from User where user_code = ? ";
            Query query = session.createQuery(hql);
            query.setParameter(0, userCode);
            User user = (User) query.uniqueResult();
            return user;
        });
        //Criteria
		/*DetachedCriteria dc = DetachedCriteria.forClass(User.class);

		dc.add(Restrictions.eq("user_code", usercode));

		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);

		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}*/
    }

    @Override
    public void save(User u) {
        getHibernateTemplate().save(u);
    }
}
