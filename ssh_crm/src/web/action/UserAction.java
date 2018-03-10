package web.action;

import com.opensymphony.xwork2.ActionSupport;
import service.UserService;

/**
 * @author super
 */
public class UserAction extends ActionSupport{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {
        System.out.println(userService);
        return SUCCESS;
    }
}
