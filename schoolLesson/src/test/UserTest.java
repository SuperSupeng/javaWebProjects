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
        friend.setName("zhangsan");
        friend.setSex("nan");
        friend.setAge(20);
        friend.setQq("842512469");
        friend.setTelephone("12563459652");
        friend.setEmail("45874521@qq.com");
        friend.setAddress("白桥");
        service.addFriend(user, friend);
    }

}
