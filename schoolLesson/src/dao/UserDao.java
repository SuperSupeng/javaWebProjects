package dao;

import domain.Friend;
import domain.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    User login(String username, String password);

    List findAllFriends(User user);

    List findAllFriends(User user, String friendName);

    void addFriend(Friend friend);

    void removeFriend(Friend friend);

    void changeFriend(Friend friend);
}
