package com.superDemo.web.controller;

import com.superDemo.commons.Page;
import com.superDemo.domain.Category;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", urlPatterns = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if("showIndex".equals(op)){
            showIndex(request, response);
        }
    }

    private void showIndex(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException{
        String num = request.getParameter("num");
        List<Category> cs = s.findAllCategories();
        Page page = s.findAllBookPageRecords(num);
        page.setUrl("/ClientServlet?op=showIndex");
        request.setAttribute("cs", cs);
        request.setAttribute("page", page);

        request.getRequestDispatcher("/listAllBooks.jsp").forward(request, response);
    }

}
