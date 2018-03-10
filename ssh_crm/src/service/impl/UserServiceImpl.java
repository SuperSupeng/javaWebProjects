package service.impl;

import dao.UserDao;
import domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

/**
 * @author super
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {
    private UserDao ud;

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    @Override
    public User getUserByCodePassword(User u) {
        System.out.println("getUserByCodePassword");
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
    public void saveUser(User u) {
        ud.save(u);
    }

}
