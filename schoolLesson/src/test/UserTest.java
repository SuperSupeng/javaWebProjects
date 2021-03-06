import domain.Friend;
import domain.User;
import org.junit.Test;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import java.util.List;

public class UserTest {
    BusinessService service = new BusinessServiceImpl();
    User user;
    Friend friend;

    @Test
    public void registerTest() {
        User user = new User();
        user.setName("aa");
        user.setPassword("123");
        service.register(user);
    }

    @Test
    public void loginTest() {
        User user = service.login("aa", "123");
        System.out.println(user);
    }

    @Test
    public void loginTest1() {
        User user = service.login("a", "123");
        assert user == null;
    }

    @Test
    public void findFriendsTest() {
        User user = service.login("aa","123");
        List list = service.findAllFriends(user);
    }

    @Test
    public void findFriendsTest1() {
        User user = service.login("aa","123");
        List list = service.findAllFriends(user, "sun");
    }

    @Test
    public void addFriendTest() {
        user = service.login("aa", "123");
        System.out.println(user.getUserid());
        friend = new Friend();
        friend.setName("六王");
        friend.setSex("男");
        friend.setAge(11);
        friend.setQq("666666");
        friend.setTelphone("15145875523");
        friend.setEmail("884571236@qq.com");
        friend.setAddress("哈尔滨");
        service.addFriend(user, friend);
    }



}
