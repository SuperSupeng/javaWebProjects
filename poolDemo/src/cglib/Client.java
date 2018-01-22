package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib库
 * 实现基于子类的动态代理
 */
public class Client {
    public static void main(String[] args){
        final SpringBrother sb = new SpringBrother();
        SpringBrother proxy = (SpringBrother) Enhancer.create(SpringBrother.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects,
                                    MethodProxy methodProxy) throws Throwable {
                if("sing".equals(method.getName())){
                    //唱歌
                    float money = (Float)objects[0];
                    if(money>10000){
                        method.invoke(sb, money/2);
                    }
                }
                if("dance".equals(method.getName())){
                    //唱歌
                    float money = (Float)objects[0];
                    if(money>20000){
                        method.invoke(sb, money/2);
                    }
                }
                return null;
            }
        });
        System.out.println(proxy instanceof SpringBrother);
        proxy.sing(100000);
        proxy.sing(50000);
    }

}
