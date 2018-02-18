package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import org.apache.struts2.ServletActionContext;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private List<User> users = new ArrayList();
    private BusinessService s = new BusinessServiceImpl();

    private String isUpload;

    public String userLogin() {
        user = s.login(user.getLogonName(), user.getLogonPwd());
        if(user==null){
            addActionError("错误的用户名或密码");
            return INPUT;
        }
        ServletActionContext.getRequest().getSession().setAttribute("user", user);
        return SUCCESS;
    }

    public String findAllUser(){
        users = s.findAllUsers();
        return SUCCESS;
    }

    public String listByCondition(){
        users = s.findUsersByCondition(user.getUserName(), user.getSex(), user.getEducation(), isUpload);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }

    @Override
    public User getModel() {
        return user;
    }
}
