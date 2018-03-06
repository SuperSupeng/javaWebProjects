package serviceProxy;

import service.UserService;
import service.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

public class UserServiceProxyFactory {
    private UserService us;

    public UserServiceProxyFactory(UserService us) {
        this.us = us;
    }

    public UserService getUserService() {
        UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启事务");
                    Object invoke = method.invoke(us, args);
                    System.out.println("关闭事务");
                    return invoke;
                });
        return usProxy;
    }
}
