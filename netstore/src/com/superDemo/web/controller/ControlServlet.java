package com.superDemo.web.controller;

import com.superDemo.domain.Category;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import com.superDemo.util.FillBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControlServlet", urlPatterns = "/ControlServlet")
public class ControlServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if("addCategory".equals(op)){
            addCategory(request,response);
        }else if("showAllCategories".equals(op)){
            showAllCategories(request,response);
        }
    }
    //查询所有分类
    private void showAllCategories(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException{
        List<Category> cs = s.findAllCategories();
        request.setAttribute("cs", cs);
        request.getRequestDispatcher("/mange/listCategory.jsp").forward(request, response);
    }
    //添加一个分类
    private void addCategory(HttpServletRequest request,
                             HttpServletResponse response)throws ServletException, IOException  {
        Category category = FillBeanUtil.fillBean(request, Category.class);
        s.addCategory(category);

        request.setAttribute("msg", "保存成功！");
        request.getRequestDispatcher("/mange/message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
