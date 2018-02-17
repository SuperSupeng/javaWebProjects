package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;
import util.DBCPUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoMySQLImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public void save(User user) {
		try {
			qr.update(
					"insert into S_User (userName,logonName,logonPwd,sex,birthday,education,telephone,interest,path,filename,remark) values (?,?,?,?,?,?,?,?,?,?,?)",
					user.getUserName(), user.getLogonName(),
					user.getLogonPwd(), user.getSex(), user.getBirthday(),
					user.getEducation(), user.getTelephone(),
					user.getInterest(), user.getPath(), user.getFilename(),
					user.getRemark());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void del(User user) {
		if (user == null || user.getUserID() == null)
			throw new IllegalArgumentException("参数不能为空");
		try {
			qr.update("delete from S_User where userID=?", user.getUserID());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(User user) {
		if (user == null || user.getUserID() == null)
			throw new IllegalArgumentException("参数不能为空");
		try {
			qr.update(
					"update S_User set userName=?,logonName=?,logonPwd=?,sex=?,birthday=?,education=?,telephone=?,interest=?,path=?,filename=?,remark=? where userID=?",
					user.getUserName(), user.getLogonName(),
					user.getLogonPwd(), user.getSex(), user.getBirthday(),
					user.getEducation(), user.getTelephone(),
					user.getInterest(), user.getPath(), user.getFilename(),
					user.getRemark(), user.getUserID());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> findAllUsers() {
		return findUserByConditions(null, null, null, null, null,null,null);
	}

	public List<User> findUserByConditions(Integer userID,String userName,String logonName,String logonPwd,String sex,String education,String filename) {
		try {
			String sql = "select * from S_User ";
			List<Object> parmaters = new ArrayList<Object>();//参数
			if (userID == null && StringUtils.isBlank(userName)
					&& StringUtils.isBlank(sex)
					&& StringUtils.isBlank(logonName)
					&& StringUtils.isBlank(logonPwd)
					&& StringUtils.isBlank(education)
					&& StringUtils.isBlank(filename)) {
				return qr.query(sql, new BeanListHandler<User>(User.class));
			} else {
				// 至少有一个参数不为空
				StringBuffer sb = new StringBuffer(sql);
				sb.append("where 1=1 ");

				if (userID != null) {
					sb.append("and userID=? ");
					parmaters.add(userID);
				}
				if (StringUtils.isNotBlank(userName)) {
					sb.append("and userName like ?");
					parmaters.add("%"+userName+"%");
				}
				if (StringUtils.isNotBlank(logonName)) {
					sb.append("and logonName=? ");
					parmaters.add(logonName);
				}
				if (StringUtils.isNotBlank(logonPwd)) {
					sb.append("and logonPwd=? ");
					parmaters.add(logonPwd);
				}
				if (StringUtils.isNotBlank(sex)) {
					sb.append("and sex=? ");
					parmaters.add(sex);
				}
				if (StringUtils.isNotBlank(education)) {
					sb.append("and education=? ");
					parmaters.add(education);
				}
				if (StringUtils.isNotBlank(filename)) {
					if ("true".equals(filename))
						sb.append("and filename is not null ");
					else
						sb.append("and filename is null");
				}
				sql = sb.toString();

			}
			return qr.query(sql,new BeanListHandler<User>(User.class), parmaters.toArray());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findUserByUsernamePassword(String logonName, String logonPwd) {
		try{
			return qr.query("select * from S_User where logonName=? and logonPwd=?", new BeanHandler<User>(User.class), logonName,logonPwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> findUsersByCondition(String userName, String sex,
			String education, String filename) {
		return findUserByConditions(null, userName, null, null, sex, education, filename);
	}

	public User findUserById(Integer userId) {
		List<User> users = findUserByConditions(userId, null, null, null, null, null, null);
		if(users!=null&&users.size()>0)
			return users.get(0);
		return null;
	}

}
