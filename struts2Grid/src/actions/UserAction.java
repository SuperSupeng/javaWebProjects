package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import org.apache.struts2.ServletActionContext;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private BusinessService s = new BusinessServiceImpl();
    private User user = new User();

    public String userLogin() {
        User u = s.login(user.getLogonName(), user.getLogonPwd());
        if(u==null){
            addActionError("错误的用户名或密码");
            return INPUT;
        }
        ServletActionContext.getRequest().getSession().setAttribute("user", user);
        return SUCCESS;
    }

    public String findAllUser(){
        return SUCCESS;
    }

    @Override
    public User getModel() {
        return user;
    }
}