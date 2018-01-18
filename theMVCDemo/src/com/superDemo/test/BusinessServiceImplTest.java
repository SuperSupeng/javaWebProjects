
import com.superDemo.domain.User;
import com.superDemo.execption.UserExistExecption;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BusinessServiceImplTest {
    private BusinessService s = new BusinessServiceImpl();

    @Test
    public void testRegister() throws UserExistExecption{
        User user = new User("wzhting", "123", "wzt@itcast.cn", new Date());
        s.register(user);
    }

    @Test(expected = com.superDemo.execption.UserExistExecption.class)
    public void testRegister1() throws UserExistExecption{
        User user = new User("wzhting", "123", "wzt@itcast.cn", new Date());
        s.register(user);
    }

    @Test
    public void testlogin(){
        User user = s.login("wzhting", "123");
        assertNotNull(user);
        user = s.login("wzhting", "111");
        assertNull(user);
        user = s.login("asf", "111");
        assertNull(user);
    }
}
