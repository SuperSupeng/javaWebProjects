package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * 添加用户信息到数据库
	 * @param user
	 */
	void save(User user);
	/**
	 * 删除用户
	 * @param user
	 */
	void del(User user);
	/**
	 * 更新用户
	 * @param user
	 */
	void update(User user);
	/**
	 * 按照条件进行查询。某些条件可能为null，就不要作为查询条件了
	 * @param userID
	 * @param userName
	 * @param sex
	 * @param education
	 * @param filename 参数为null或""，表示忽略该参数；如果为一个字符串"true"，判断该字段有值
	 * @return
	 */
	List<User> findUserByConditions(Integer userID,String userName,String logonName,String logonPwd,String sex,String education,String filename);
	/**
	 * 根据用户名和密码查询
	 * @param logonName
	 * @param logonPwd
	 * @return
	 */
	User findUserByUsernamePassword(String logonName,String logonPwd);
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findAllUsers();
	/**
	 * 按照条件进行查询
	 * 只把非null的参数作为查询条件
	 * @param userName
	 * @param sex
	 * @param education
	 * @param filename
	 * @return
	 */
	List<User> findUsersByCondition(String userName,String sex,String education,String filename);
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	User findUserById(Integer userId);
}
