package springAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springAop/applicationContext.xml")
public class Demo {
    @Resource(name="userService")
    private UserService us;

    @Test
    public void fun1(){
        us.save();
    }
}
