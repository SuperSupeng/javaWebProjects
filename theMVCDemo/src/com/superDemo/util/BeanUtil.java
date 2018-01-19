package com.superDemo.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

public class BeanUtil {
    public static <T> T fillBean(HttpServletRequest request, Class<T> clazz){
        try {
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, request.getParameterMap());
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
