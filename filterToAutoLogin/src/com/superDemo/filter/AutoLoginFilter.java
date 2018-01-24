package com.superDemo.filter;

import com.superDemo.domain.User;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import com.superDemo.util.SecurityUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AutoLoginFilter implements Filter {
    private BusinessService s = new BusinessServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        try{
            request = (HttpServletRequest) servletRequest;
            response = (HttpServletResponse) servletResponse;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        HttpSession session = request.getSession();

        User sUser = (User) session.getAttribute("user");

        if(sUser == null){
            Cookie []cookies = request.getCookies();
            for(int i = 0; cookies!=null&&i<cookies.length; i++){
                String usernamePassword = cookies[i].getValue();
                String username = usernamePassword.split("_")[0];//base64编码后的
                String password = usernamePassword.split("_")[1];//MD5加密后的
                //调用Service再次验证正确性
                User user = s.login(SecurityUtil.base64decoder(username), password);
                //通过：登录。在HttpSession中设置登录标记
                if(user!=null){
                    session.setAttribute("user", user);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
