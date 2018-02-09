package action;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
    public String addCustomer(){
        //调用Service
        System.out.println("addCustomer");
        return SUCCESS;
    }
    public String updateCustomer(){
        System.out.println("updateCustomer");
        return SUCCESS;
    }
    public String delCustomer(){
        System.out.println("delCustomer");
        return SUCCESS;
    }
    public String findCustomer(){
        System.out.println("findCustomer");
        return SUCCESS;
    }
}
