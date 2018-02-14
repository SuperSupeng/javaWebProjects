package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BusinessService;

public class SpringContainerTest {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        BusinessService s1 = (BusinessService)ac.getBean("businessService");
        BusinessService s2 = (BusinessService)ac.getBean("businessService");
//		System.out.println(s1);
//		System.out.println(s2);
        s1.regist();
    }
}
