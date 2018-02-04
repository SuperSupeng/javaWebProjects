package service;

import domain.User;
import exception.UserAlreadyExistedException;

public interface BusinessService {

     /**
     * 用户注册
     * @param user 注册的用户信息
     * @throws UserAlreadyExistedException 若用户已存在则不允许注册
     */
    void register(User user) throws UserAlreadyExistedException;

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
