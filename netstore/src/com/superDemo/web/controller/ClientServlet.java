package com.superDemo.web.controller;

import com.superDemo.commons.Page;
import com.superDemo.domain.Book;
import com.superDemo.domain.Category;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import com.superDemo.web.beans.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        }else if("showCategoryBooks".equals(op)){
            showCategoryBooks(request, response);
        }else if("showBookDetails".equals(op)){
            showBookDetails(request, response);
        }else if("buyBook".equals(op)){
            buyBook(request, response);
        }
    }

    private void buyBook(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        Book book = s.findBookById(bookId);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addBook(book);
        request.setAttribute("msg", "书籍已经放入您的购物车，<a href='"+request.getContextPath()+"'>继续购物</a>");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    private void showBookDetails(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException{
        String bookId = request.getParameter("bookId");
        Book book = s.findBookById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/showDetails.jsp").forward(request, response);
    }

    private void showCategoryBooks(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException{
        String num = request.getParameter("num");
        String categoryId = request.getParameter("categoryId");

        //查询所有的分类
        List<Category> cs = s.findAllCategories();
        //查询所有的分页书籍
        Page page = s.findAllBookPageRecords(num, categoryId);
        page.setUrl("/ClientServlet?op=showCategoryBooks&categoryId="+categoryId);

        request.setAttribute("cs",cs);
        request.setAttribute("page", page);

        request.getRequestDispatcher("/listAllBooks.jsp").forward(request, response);

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
