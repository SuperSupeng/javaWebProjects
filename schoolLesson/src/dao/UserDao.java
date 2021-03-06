package dao;

import domain.Friend;
import domain.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    User login(String username, String password);

    List findAllFriends(User user);

    List findAllFriends(User user, String friendName);

    void addFriend(User user, Friend friend);

    void removeFriend(User user, Friend friend);

    void changeFriend(User user, Friend friend);

    User findByUserID(String userId);
}
