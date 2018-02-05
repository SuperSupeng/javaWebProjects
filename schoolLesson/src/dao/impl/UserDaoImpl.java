package dao.impl;

import dao.FriendDao;
import dao.UserDao;
import domain.Friend;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.DBCPUtil;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    FriendDao friendDao = new FriendDaoImpl();

    @Override
    public void save(User user) {
        try{
            qr.update("insert into user(userid, name, password) values (?,?,?)",
                    user.getUserid(),
                    user.getName(),
                    user.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            return qr.query("select * from user where name=? and password=?",
                    new BeanHandler<>(User.class),username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findAllFriends(User user) {
        return friendDao.findAllFriends(user);
    }

    @Override
    public List findAllFriends(User user, String friendName) {
        return friendDao.findAllFriends(user, friendName);
    }

    @Override
    public void addFriend(User user, Friend friend) {
        friendDao.addFriend(user, friend);
    }

    @Override
    public void removeFriend(User user, Friend friend) {
        friendDao.removeFriend(user, friend);
    }

    @Override
    public void changeFriend(User user, Friend friend) {
        friendDao.changeFriend(user, friend);
    }

    @Override
    public User findByUserID(String userId) {
        try {
            return qr.query("select * from user where id=?",
                    new BeanHandler<>(User.class),userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
