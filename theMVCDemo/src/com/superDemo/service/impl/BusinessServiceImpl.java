package com.superDemo.service.impl;

import com.superDemo.dao.UserDao;
import com.superDemo.dao.impl.UserDaoXmlImpl;
import com.superDemo.domain.User;
import com.superDemo.execption.UserExistExecption;
import com.superDemo.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
    private UserDao dao = new UserDaoXmlImpl();
    @Override
    public void register(User user) throws UserExistExecption {
        User dbUser = dao.finUserByUsername(user.getUsername());
        if(dbUser != null){
            throw new UserExistExecption("用户名： " + user.getUsername() +"已经存在！");
        }
        dao.save(user);
    }

    @Override
    public User login(String username, String password) {
        return dao.findUser(username, password);
    }
}
