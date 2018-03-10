package dao;

import domain.User;

public interface UserDao {
    User getByUserCode(String userCode);

    void save(User u);
}
