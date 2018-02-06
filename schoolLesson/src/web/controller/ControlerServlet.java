package web.controller;

import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControlerServlet", urlPatterns = "/ControlerServlet")
public class ControlerServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if ("signin".equals(op)) {
            signin(request, response);
        }else if("logout".equals(op)){
            logout(request, response);
        }else if("register".equals(op)){
            register(request, response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        s.register(user);
        response.sendRedirect(request.getContextPath());
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath());
    }

    private void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = s.login(username, password);
        if(user == null){
            request.getSession().setAttribute("msg", "登录信息有误");
        }else{
            request.getSession().setAttribute("user", user);
            request.getSession().removeAttribute("msg");
        }
        response.sendRedirect(request.getContextPath());
    }
}
