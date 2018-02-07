package web.controller;

import domain.Friend;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
        }else if("showFriends".equals(op)){
            showFriends(request, response);
        }else if("delOneFriend".equals(op)){
            delOneFriend(request, response);
        }else if("search".equals(op)){
            search(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("searchOne");
        System.out.println(search + "qqqqqqqqqq");
        List friends = s.findAllFriends((User) request.getSession().getAttribute("user"), search);
        request.getSession().setAttribute("friends", friends);
        response.sendRedirect(request.getContextPath()+"/contacts.jsp");
    }


    private void delOneFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        System.out.println(id + "aaaaaaaaaaa");
        Friend friend = new Friend();
        friend.setId(id);
        User user = (User) session.getAttribute("user");
        s.removeFriend(user, friend);
        List<Friend> friends = s.findAllFriends(user);
        session.setAttribute("friends", friends);
        response.sendRedirect(request.getContextPath() + "/contacts.jsp");
    }

    private void showFriends(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Friend> friends = s.findAllFriends((User) session.getAttribute("user"));
        session.setAttribute("friends", friends);
        response.sendRedirect(request.getContextPath()+"/contacts.jsp");
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
