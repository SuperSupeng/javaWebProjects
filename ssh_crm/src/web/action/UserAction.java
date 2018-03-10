package web.action;

import com.opensymphony.xwork2.ActionSupport;
import service.UserService;

/**
 * @author super
 */
public class UserAction extends ActionSupport{
    private UserService us;

    public void setUs(UserService us) {
        this.us = us;
    }
}
