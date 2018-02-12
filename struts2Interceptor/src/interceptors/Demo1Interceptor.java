package interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo1Interceptor extends AbstractInterceptor {
    @Override
    public void init() {
        System.out.println("Demo1Interceptor初始化了");
        super.init();
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object currentAction = actionInvocation.getProxy();
        System.out.println(currentAction.getClass().getName());
        System.out.println("Demo1Interceptor拦截前");
        String rtValue = actionInvocation.invoke();
        System.out.println("Demo1Interceptor拦截后");
        return rtValue;
    }
}
