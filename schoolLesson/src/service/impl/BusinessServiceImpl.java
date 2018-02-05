package service.impl;

import dao.FriendDao;
import dao.UserDao;
import dao.impl.FriendDaoImpl;
import dao.impl.UserDaoImpl;
import domain.Friend;
import domain.User;
import exception.UserAlreadyExistedException;
import service.BusinessService;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user){
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public List findAllFriends(User user) {
        return userDao.findAllFriends(user);
    }

    @Override
    public List findAllFriends(User user, String friendName) {
        return userDao.findAllFriends(user, friendName);
    }

    @Override
    public void addFrined(Friend friend) {
        userDao.addFriend(friend);
    }

    @Override
    public void removeFrined(Friend friend) {
        userDao.removeFriend(friend);
    }

    @Override
    public void changeFrined(Friend friend) {
        userDao.changeFriend(friend);
    }
}
