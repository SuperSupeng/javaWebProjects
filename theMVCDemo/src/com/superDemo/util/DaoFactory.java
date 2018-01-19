package com.superDemo.util;

import com.superDemo.dao.UserDao;

import java.util.ResourceBundle;

public class DaoFactory {
	
	public static UserDao getUserDao(){
		try {
			ResourceBundle rb = ResourceBundle.getBundle("dao");
			String className = rb.getString("userDao");
			return (UserDao)Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
