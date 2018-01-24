package com.superDemo.web.controller;

import com.superDemo.domain.User;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import com.superDemo.util.SecurityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto = request.getParameter("auto");

        password = SecurityUtil.md5(password);

        User user = s.login(username, password);
        if(user == null){
            response.getWriter().write("用户名或密码错误");
            return;
        }

        request.getSession().setAttribute("user", user);

        if(auto != null){
            Cookie cookie = new Cookie("loginInfo", SecurityUtil.base64encoder(username) + "_" + password);
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
        }

        response.sendRedirect(request.getContextPath());
    }
}
