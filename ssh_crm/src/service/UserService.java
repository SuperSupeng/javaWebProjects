package service;

import domain.User;

public interface UserService {
    User getUserByCodePassword(User u);

    void saveUser(User u);
}
