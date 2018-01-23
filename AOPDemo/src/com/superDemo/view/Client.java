package com.superDemo.view;

import com.superDemo.service.BusinessService;
import com.superDemo.util.BusinessServiceFactory;

public class Client {
    public static void main(String[] args){
        BusinessService s = BusinessServiceFactory.getBusinessService();
        s.transfer("aaa", "bbb", 100);
    }
}
