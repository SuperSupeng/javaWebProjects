package action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

public class PersonAction extends ActionSupport{
    private String username;
    private String password;
    private String repassword;
    private String email;
    private Date birthday;
    private String netaddress;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepassword() {
        return repassword;
    }
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getNetaddress() {
        return netaddress;
    }
    public void setNetaddress(String netaddress) {
        this.netaddress = netaddress;
    }
    public String regist(){
        System.out.println(this);
        return SUCCESS;
    }
    @Override
    public String toString() {
        return "StudentAction [username=" + username + ", password=" + password
                + ", repassword=" + repassword + ", email=" + email
                + ", birthday=" + birthday + ", netaddress=" + netaddress + "]";
    }
}
