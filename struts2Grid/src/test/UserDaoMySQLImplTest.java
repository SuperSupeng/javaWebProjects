import dao.UserDao;
import dao.impl.UserDaoMySQLImpl;
import org.junit.Test;

public class UserDaoMySQLImplTest {
	private UserDao dao = new UserDaoMySQLImpl();
	@Test
	public void testFindUserByConditions() {
		dao.findUserByConditions(null,null,null, null, null, null, "false");
	}

}
