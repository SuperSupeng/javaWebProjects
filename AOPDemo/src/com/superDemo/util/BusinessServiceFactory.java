package com.superDemo.util;

import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;

import java.lang.reflect.Proxy;

/**
 * 面向切片编程
 */
public class BusinessServiceFactory {
    public static BusinessService getBusinessService(){
        BusinessService s = new BusinessServiceImpl();

        BusinessService proxyS = (BusinessService) Proxy.newProxyInstance(s.getClass().getClassLoader(),
                s.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    try{
                        TransactionManger.startTransaction();
                        Object rtValue = method.invoke(s, args);
                        return rtValue;
                    }catch (Exception e){
                        TransactionManger.rollback();
                        throw new RuntimeException(e);
                    }finally {
                        TransactionManger.commit();
                        TransactionManger.release();
                    }
                });
        return proxyS;
    }
}
