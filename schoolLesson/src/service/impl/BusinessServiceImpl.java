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
import java.util.UUID;

public class BusinessServiceImpl implements BusinessService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user){
        user.setUserid(UUID.randomUUID().toString());
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
    public void addFriend(User user, Friend friend) {
        friend.setId(UUID.randomUUID().toString());
        userDao.addFriend(user, friend);
    }

    @Override
    public void removeFriend(User user, Friend friend) {
        userDao.removeFriend(user, friend);
    }

    @Override
    public void changeFriend(User user, Friend friend) {
        userDao.changeFriend(user, friend);
    }
}
