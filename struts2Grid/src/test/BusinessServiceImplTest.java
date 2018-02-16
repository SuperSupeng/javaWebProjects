package com.itheima.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;

public class BusinessServiceImplTest {
	private BusinessService s = new BusinessServiceImpl();
	@Test	
	public void testLogin() {
		User user = s.login("wzhting", "sorry");
		assertNotNull(user);
		user = s.login("aaa", "123");
		assertNull(user);
	}
	@Test
	public void testAddUser() {
		User user = new User("bb", "bbb", "bbbb", "renyao", "1999", "胎教", "114", "sex", "/a/a/b", "a.jpg", "rrrr");
		s.addUser(user);
	}

	@Test
	public void testEditUser() {
		User user = s.findUserById(4);
		user.setUserName("shit");
		s.editUser(user);
	}

	@Test
	public void testFindUserById() {
		User user = s.findUserById(4);
		assertNotNull(user);
		user = s.findUserById(438);
		assertNull(user);
	}

	@Test
	public void testDelUser() {
		User user = s.findUserById(4);
		s.delUser(user);
	}
	@Test
	public void testFindAllUsers() {
		List<User> us = s.findAllUsers();
		System.out.println(us);
	}

	@Test
	public void testFindUsersByCondition() {
		List<User> us = s.findUsersByCondition("", "", "", "");
		System.out.println(us);
	}
	@Test
	public void testFindUsersByCondition1() {
		List<User> us = s.findUsersByCondition("王", "", "", "");
		System.out.println(us);
	}
	@Test
	public void testFindUsersByCondition2() {
		List<User> us = s.findUsersByCondition("", "male", "", "");
		System.out.println(us);
	}
	@Test
	public void testFindUsersByCondition3() {
		List<User> us = s.findUsersByCondition("", "", "博士", "");
		System.out.println(us);
	}
	@Test
	public void testFindUsersByCondition4() {
		List<User> us = s.findUsersByCondition("", "", "", "sadf");
		System.out.println(us);
	}
	@Test
	public void testFindUsersByCondition5() {
		List<User> us = s.findUsersByCondition("王", "", "本科", "");
		System.out.println(us);
	}
	

}
