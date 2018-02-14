package action;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String regist() throws InterruptedException{
        System.out.println("保存的内容是："+username);
        Thread.sleep(2000);
        return SUCCESS;
    }
}
