package service;

import domain.User;

import java.util.List;

//根据功能需求来做
public interface BusinessService {
	/**
	 * 用户登录
	 * @param logonName
	 * @param logonPwd
	 * @return 用户名或密码错误，返回null
	 */
	User login(String logonName, String logonPwd);
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
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 修改用户信息
	 * @param user
	 */
	void editUser(User user);
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	User findUserById(Integer userId);
	/**
	 * 删除用户
	 * @param userId
	 */
	void delUser(User user);
}
