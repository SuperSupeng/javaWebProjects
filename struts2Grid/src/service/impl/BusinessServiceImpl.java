package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoMySQLImpl;
import com.itheima.domain.User;
import com.itheima.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private UserDao dao = new UserDaoMySQLImpl();
	
	
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public User login(String logonName, String logonPwd) {
		return dao.findUserByUsernamePassword(logonName, logonPwd);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public List<User> findUsersByCondition(String userName, String sex,
			String education, String filename) {
		return dao.findUsersByCondition(userName, sex, education, filename);
	}

	public void addUser(User user) {
		dao.save(user);
	}

	public void editUser(User user) {
		dao.update(user);
	}

	public User findUserById(Integer userId) {
		return dao.findUserById(userId);
	}

	public void delUser(User user) {
		dao.del(user);
	}

}
