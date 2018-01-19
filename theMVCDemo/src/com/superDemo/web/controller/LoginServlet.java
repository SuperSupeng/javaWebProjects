package com.superDemo.web.controller;

import com.superDemo.domain.User;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private BusinessService s = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = s.login(username, password);
		if(user==null){
			out.write("错误的用户名或密码.2秒后转向登录页面");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
