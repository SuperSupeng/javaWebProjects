package action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport{
    @Override
    public String execute() throws Exception {
        String s = getText("hello");
        System.out.println(s);
        return NONE;
    }

    public String m1(){
        return SUCCESS;
    }
}
