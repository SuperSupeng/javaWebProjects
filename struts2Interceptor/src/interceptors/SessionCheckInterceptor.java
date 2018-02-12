package interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class SessionCheckInterceptor extends MethodFilterInterceptor{
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Object o = session.getAttribute("user");
        if(o!=null){
            return actionInvocation.invoke();
        }else{
            return Action.LOGIN;
        }
    }
}
