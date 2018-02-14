package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class Demo1Action extends ActionSupport{
    public String execute(){

        //向传统的四大域对象放数据
//		ServletActionContext.getRequest().setAttribute("p", "rp");
        ServletActionContext.getRequest().getSession().setAttribute("p", "sp");
        ServletActionContext.getServletContext().setAttribute("p", "ap");

        return SUCCESS;
    }
}
