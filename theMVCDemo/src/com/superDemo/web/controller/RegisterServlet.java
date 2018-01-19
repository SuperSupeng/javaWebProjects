package com.superDemo.web.controller;

import com.superDemo.domain.User;
import com.superDemo.execption.UserExistExecption;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import com.superDemo.util.BeanUtil;
import com.superDemo.web.bean.UserFormBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFormBean formBean = null;
        formBean = BeanUtil.fillBean(request, UserFormBean.class);
        if(!formBean.validate()){
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        User user = new User();
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        try {
            BeanUtils.copyProperties(user, formBean);
            s.register(user);
            response.sendRedirect(request.getContextPath());
        }catch (UserExistExecption e){
            formBean.getErrors().put("username", e.getMessage());
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
