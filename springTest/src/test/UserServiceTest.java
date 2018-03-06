import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;
import serviceProxy.UserServiceProxyFactory;

public class UserServiceTest {

    @Test
    public void test() {
        UserService userService = new UserServiceImpl();
        UserServiceProxyFactory factory = new UserServiceProxyFactory(userService);
        UserService userServiceProxy = factory.getUserService();
        userServiceProxy.save();
    }
}
