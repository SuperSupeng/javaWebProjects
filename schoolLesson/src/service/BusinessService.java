package service;

import domain.Friend;
import domain.User;
import exception.UserAlreadyExistedException;

import java.util.List;

public interface BusinessService {

     /**
     * 用户注册
     * @param user 注册的用户信息
     */
    void register(User user);

    /**
     * 按照用户名密码登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 查询指定用户的所有好友
     * @param user
     * @return
     */
    List findAllFriends(User user);

    /**
     * 按照好友姓名模糊查询用户的所有好友
     * @param user
     * @param frinedName
     * @return
     */
    List findAllFriends(User user, String frinedName);

    /**
     * 添加好友
     * @param friend
     */
    void addFriend(User user, Friend friend);

    /**
     * 删除好友
     * @param friend
     */
    void removeFriend(User user, Friend friend);

    /**
     * 修改好友信息
     * @param friend
     */
    void changeFriend(User user, Friend friend);

    /**
     * 通过id查询好友
     * @param friendId
     * @return
     */
    Friend findFriendById(String friendId);
}
