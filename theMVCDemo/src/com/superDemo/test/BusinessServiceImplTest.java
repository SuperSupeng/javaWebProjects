
import com.superDemo.domain.User;
import com.superDemo.execption.UserExistExecption;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;

import org.junit.Test;

import java.util.Date;

public class BusinessServiceImplTest {
    private BusinessService s = new BusinessServiceImpl();

    @Test
    public void testRegister() throws UserExistExecption{
        User user = new User("wzhting", "123", "wzt@itcast.cn", new Date());
        s.register(user);
    }
    
}
