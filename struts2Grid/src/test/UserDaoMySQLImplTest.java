package com.itheima.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoMySQLImpl;

public class UserDaoMySQLImplTest {
	private UserDao dao = new UserDaoMySQLImpl();
	@Test
	public void testFindUserByConditions() {
		dao.findUserByConditions(null,null,null, null, null, null, "false");
	}

}
