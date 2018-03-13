package dao.impl;

import dao.CustomerDao;
import entity.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CustomerDaoImplTest {

    @Test
    public void findById() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CustomerDao customerDao = (CustomerDao) app.getBean("customerDao");
        Customer customer = customerDao.findById(23L);
        System.out.println(customer);
    }
}