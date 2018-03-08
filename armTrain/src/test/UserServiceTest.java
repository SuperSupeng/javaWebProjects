import domain.User;
import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserServiceTest {

    @Test
    public void testSave(){
        UserService service = new UserServiceImpl();
        User u = new User();
        service.save(u);
    }

}
